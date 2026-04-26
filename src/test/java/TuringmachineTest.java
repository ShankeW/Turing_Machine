import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TuringMachineTest {
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private final TuringMachine TM = new TuringMachine();

    @Test
    public void parserTM1Test(){
        String Input = "010010001010011000101010010110001001001010011000100010001010";
        TM.parse(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(new ImageFunction(3, 1, 2), mapping.get(new SourceFunction(1, 2)));
        assertEquals(new ImageFunction(1, 2, 1), mapping.get(new SourceFunction(3, 1)));
        assertEquals(new ImageFunction(2, 1, 2), mapping.get(new SourceFunction(3, 2)));
        assertEquals(new ImageFunction(3, 1, 1), mapping.get(new SourceFunction(3, 3)));
    }

    @Test
    public void parserTM2Test(){
        String Input = "1010010100100110101000101001100010010100100110001010010100";
        TM.parse(Input);
        Map<SourceFunction, ImageFunction> mapping = TM.getTransitionMapping();
        assertEquals(new ImageFunction(3, 1, 2), mapping.get(new SourceFunction(1, 1)));
        assertEquals(new ImageFunction(1, 2, 2), mapping.get(new SourceFunction(1, 2)));
        assertEquals(new ImageFunction(1, 2, 2), mapping.get(new SourceFunction(3, 2)));
        assertEquals(new ImageFunction(2, 1, 2), mapping.get(new SourceFunction(3, 1)));
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
        String Input1 = "10";
        TM.parse(GödelNumber);
        assertFalse(TM.calculate(Input0, 1));
        assertFalse(TM.calculate(Input1, 1));
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

    @Test
    public void showTapeContentTM1Test() {
        System.setOut(new PrintStream(outputCaptor)); // capture output
        Tape tape = new Tape();
        int[] input = {1, 1, 0, 0};
        tape.initTapeWithInput(input);
        tape.setTapeLength(15);
        tape.showTape();
        String outputTape = outputCaptor.toString();
        assertEquals("               v\n| | | | | | | |1|1|0|0| | | | |\n\n", outputTape);
    }

    @AfterEach
    public void resetSystemOut() {
        // Always restore the original stream so you don't break other tests
        System.setOut(original);
    }
}
