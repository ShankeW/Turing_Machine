import java.util.HashMap;

/**
 * This class represents the turing machine's tape.
 * The tape can be updated with state information and shown in the terminal.
 */

public class Tape {
    private String[] TapeAlphabet = {"0", "1", "B", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    private String[] InputWord = {"0", "1"};
    private String[] HeadMove = {"1", "2"}; // 1 for left move 2 for right move
    private HashMap<Integer, Integer> Tape;

    public void initTapeWithInput(String input) {

    }

    public void updateTape(int nextState, int write, int nextHeadPos) {

    }

    public void showTape() {

    }
}
