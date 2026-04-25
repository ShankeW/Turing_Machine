import java.util.HashMap;
import java.util.Optional;

/**
 * This class represents the turing machine's tape.
 * The tape can be updated with state information and shown in the terminal.
 */
public class Tape {
    private String[] TapeAlphabet = {"0", "1", "B", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    private String[] InputWord = {"0", "1"};
    private String[] HeadMove = {"1", "2"}; // 1 for left move 2 for right move
    private int HeadPos = 0;
    private HashMap<Integer, Integer> Tape = new HashMap<>();

    public void initTapeWithInput(int[] input) {
        clearTape();
        for (int curr : input) {
            Tape.put(HeadPos, (curr + 1));
            HeadPos++;
        }
        HeadPos = 0;
    }

    public void updateTape(int nextState, int write, int nextHeadPos) {
        Tape.put(HeadPos, write);
        HeadPos = nextHeadPos == 1 ? HeadPos - 1 : HeadPos + 1 ;
    }

    public Optional<Integer> getHeadPosElement() {
        return Optional.ofNullable(Tape.get(getHeadPos()));
    }

    public void clearTape(){
        Tape = new HashMap<>();
        HeadPos = 0;
    }

    public void showTape() {
        // Use integer mapping to pick the correct character from tape alphabets
        // if map is null, print a blank tape representation
    }

    public int getHeadPos() {
        return HeadPos;
    }

}
