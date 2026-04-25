import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the turing machine and owns the main calculation logic
 * Basic definitions:
 *  -   State definition: Start state = 1, Accepted state = 2, other states beginn with = 3, 4, 5...
 *  -   Input Alphabets: 0, 1, B (for blank)
 *  -   Machine Head: 1 for moving left and 2 for moving right
 * */
public class TuringMachine {
    private Map<SourceFunction, ImageFunction> Transitions = new HashMap<>();
    private int Counter;
    private int CurrTapePosition;
    private final int StartState = 1;
    private final int AcceptedState = 2;
    private Tape tape;

    public TuringMachine(String goedelnumber){
        Counter = 0;
        CurrTapePosition = 1;
        tape = new Tape();
    }

    /**
     * Main calculation logic
     * @param input from user
     * @return result of the calculation
     */
    public int calculate(String input){
        tape.initTapeWithInput(input);

        String[] parsedInput = input.split("");
        for(String curr : parsedInput) {

        }

        return 0;
    }

    public int calculateInStep() {
        return -1;
    }

    public int calculateInRun() {
        return -1;
    }

    /**
     * Parses and stores all transition functions in a map.
     * @param goedNum is the input that should be interpreted as a set of transition functions
     * return true if parser completes successfully, false if the gödel number is invalid
     */
    public boolean parse(String goedNum){

        String[] parsedTransitions = goedNum.split("11"); // Store each transition as one element
        for (String parsedTransition : parsedTransitions) {
            String[] parsedZeros = parsedTransition.split("1");
            if (parsedZeros.length != 5) {
                return false;
            }
            Transitions.put(
                    new SourceFunction(parsedZeros[0].length(), parsedZeros[1].length()),
                    new ImageFunction(parsedZeros[2].length(), parsedZeros[3].length(), parsedZeros[4].length())
            );
        }

        return true;
    }

    public Map<SourceFunction, ImageFunction> getTransitionMapping(){
        return Transitions;
    }

    public int nextState(){
        return 0;
    }
}
