import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class represents the turing machine and owns the main calculation logic
 * Basic definitions:
 *  -   State definition: Start state = 1, Accepted state = 2, other states beginn with = 3, 4, 5...
 *  -   Input Alphabets: 0, 1, B (for blank)
 *  -   Machine Head: 1 for moving left and 2 for moving right
 * */
public class TuringMachine {
    private final Map<SourceFunction, ImageFunction> Transitions = new HashMap<>();
    private final Tape tape;
    private int Counter;
    private int CurrState;

    public TuringMachine(){
        Counter = 0;
        CurrState = 1;
        tape = new Tape();
    }

    /**
     * Main calculation logic
     * @param input from user
     * @return true if the input is accepted, false otherwise
     */
    public boolean calculate(String input, int modus){
        // convert input to Integer Array and initialize the tape
        int inputLength = input.length();
        String[] parsedInput = input.split("");
        int[] parsedInputAsInt = new int[inputLength];
        for(int i = 0; i < inputLength; i++) {
            parsedInputAsInt[i] = parsedInput[i].charAt(0) - '0';
        }
        tape.initTapeWithInput(parsedInputAsInt);

        // process stored input on the tape till the accepted state is achieved
        while (getCurrState() != 2) {
            if (tape.getHeadPosElement().isEmpty()) return false; // No more alphabets on the tape. Not possible to proceed
            SourceFunction processTapeElement = new SourceFunction(getCurrState(), tape.getHeadPosElement().get());
            ImageFunction mapForInput = Transitions.get(processTapeElement);
            if (mapForInput != null) { // proceed only if the next calculation step exists
                int nextState = mapForInput.getState();
                int write = mapForInput.getAlphabet();
                int nextHeadPos = mapForInput.getHead();
                tape.updateTape(nextState, write, nextHeadPos);
                setCurrState(nextState);
                incrementCounter();
            } else { // get stuck
                return false;
            }

            // show tape content for step-modus
            if (modus == 2) tape.showTape();
        }

        return true;
    }

    public void calculateInRun(String input) {
        calculate(input, 1);
    }

    public void calculateInStep(String input) {
        calculate(input, 2);
    }

    /**
     * Parses and stores all transition functions in a map.
     * @param goedNum is the input that should be interpreted as a set of transition functions
     * return true if parser completes successfully, false if the gödel number is invalid
     */
    public boolean parse(String goedNum){
        // trim and remove leading 1 from the input if any exists.
        goedNum = goedNum.trim();
        if (goedNum.charAt(0) == '1') {
            goedNum = goedNum.substring(1);
        }
        if (goedNum.charAt(goedNum.length() - 1) == '1') return false;

        // Store transitions in map
        String[] parsedTransitions = goedNum.split("11");
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

    public int getCounter() {
        return Counter;
    }

    public void incrementCounter() {
        Counter++;
    }

    public int getCurrState() {
        return CurrState;
    }

    public void setCurrState(int currState) {
        CurrState = currState;
    }

    public Tape getTape() {
        return tape;
    }
}
