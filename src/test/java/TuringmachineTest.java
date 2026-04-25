import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TuringMachineTest {

    TuringMachine TM = new TuringMachine();

    @Test
    public void parserTM1Test(){
        String Input = "010010001010011000101010010110001001001010011000100010001010";
        TM.parse(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(mapping.get(new SourceFunction(1, 2)), new ImageFunction(3, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 1)), new ImageFunction(1, 2, 1));
        assertEquals(mapping.get(new SourceFunction(3, 2)), new ImageFunction(2, 1, 2));
        assertEquals(mapping.get(new SourceFunction(3, 3)), new ImageFunction(3, 1, 1));
    }

    @Test
    public void parserTM2Test(){
        String Input = "1010010100100110101000101001100010010100100110001010010100";
        TM.parse(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(mapping.get(new SourceFunction(1, 1)), new ImageFunction(3, 1, 2));
        assertEquals(mapping.get(new SourceFunction(1, 2)), new ImageFunction(1, 2, 2));
        assertEquals(mapping.get(new SourceFunction(3, 2)), new ImageFunction(1, 2, 2));
        assertEquals(mapping.get(new SourceFunction(3, 1)), new ImageFunction(2, 1, 2));
    }

    @Test
    public void calculateSuccessTM1Test(){
        String GödelNumber = "010010001010011000101010010110001001001010011000100010001010";
        String Input0 = "11";
        String Input1 = "110";
        TM.parse(GödelNumber);
        assertTrue(TM.calculate(Input0, 1));
        assertTrue(TM.calculate(Input1, 1));
    }

    @Test
    public void calculateSuccessTM2Test(){
        String GödelNumber = "1010010100100110101000101001100010010100100110001010010100";
        String Input0 = "1100";
        String Input1 = "0011";
        TM.parse(GödelNumber);
        assertTrue(TM.calculate(Input0, 1));
        assertTrue(TM.calculate(Input1, 1));
    }

    @Test
    public void calculateFailureTM1Test(){
        String GödelNumber = "010010001010011000101010010110001001001010011000100010001010";
        String Input0 = "011";
        TM.parse(GödelNumber);
        assertFalse(TM.calculate(Input0, 1));
    }

    @Test
    public void calculateFailureTM2Test(){
        String GödelNumber = "1010010100100110101000101001100010010100100110001010010100";
        String Input0 = "0";
        String Input1 = "1";
        String Input2 = "01";
        String Input3 = "10";
        TM.parse(GödelNumber);
        assertFalse(TM.calculate(Input0, 1));
        assertFalse(TM.calculate(Input1, 1));
        assertFalse(TM.calculate(Input2, 1));
        assertFalse(TM.calculate(Input3, 1));
    }
}
