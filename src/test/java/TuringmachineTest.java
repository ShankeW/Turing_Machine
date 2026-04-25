import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TuringMachineTest {

    @Test
    public void parserTest(){
        String Input = "010010001010011000101010010110001001001010011000100010001010";
        TuringMachine TM = new TuringMachine(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(mapping.get(new SourceFunction(1, 2)), new ImageFunction(3, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 1)), new ImageFunction(1, 2, 1));
        assertEquals(mapping.get(new SourceFunction(3, 2)), new ImageFunction(2, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 3)), new ImageFunction(3, 1, 1));
    }
}
