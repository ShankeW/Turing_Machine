import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TuringMachineTest {

    TuringMachine TM = new TuringMachine();

    @Test
    public void parserTest(){
        String Input = "010010001010011000101010010110001001001010011000100010001010";
        TM.parse(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(mapping.get(new SourceFunction(1, 2)), new ImageFunction(3, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 1)), new ImageFunction(1, 2, 1));
        assertEquals(mapping.get(new SourceFunction(3, 2)), new ImageFunction(2, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 3)), new ImageFunction(3, 1, 1));
    }

    @Test
    public void calculateTest(){
        String GödelNumber = "010010001010011000101010010110001001001010011000100010001010";
        String Input0 = "11";
        String Input1 = "110";
        TM.parse(GödelNumber);
        assertTrue(TM.calculate(Input0));
        assertTrue(TM.calculate(Input1));
    }
}
