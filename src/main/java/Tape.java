import java.util.HashMap;
import java.util.Optional;

/**
 * This class represents the turing machine's tape.
 * The tape can be updated with state information and can be shown in the terminal.
 * The tape alphabets are defined as 0, 1, ..., j, k.
 */
public class Tape {
    private final String[] TapeAlphabet = {"0", "1", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    private int HeadPos = 0;
    private int TapeLength = 31;
    private HashMap<Integer, Integer> Tape = new HashMap<>();

    /**
     * Put the given user input on to the tape.
     * @param input provided by user.
     */
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
        HeadPos = (nextHeadPos == 1) ? HeadPos - 1 : HeadPos + 1 ;
    }

    /**
     * Get the element in the cell that is pointed by the write/read head at the moment.
     * @return this element.
     */
    public Optional<Integer> getHeadPosElement() {
        if (Optional.ofNullable(Tape.get(getHeadPos())).isEmpty()) {
            Tape.put(getHeadPos(), 3);
        }
        return Optional.ofNullable(Tape.get(getHeadPos()));
    }

    public void clearTape(){
        Tape = new HashMap<>();
        HeadPos = 0;
    }

    public void showTape() {
        int startIndex = getHeadPos() - getTapeLength() / 2;
        int endIndex = getHeadPos() + getTapeLength() / 2;

        // print write/read head
        System.out.print(" ");
        for (int i = startIndex; i < getHeadPos(); i++) {
            System.out.print("  ");
        }
        System.out.println("v");

        // print tape
        System.out.print("|");
        for (int i = startIndex; i <= endIndex; i++) {
            if (Tape.get(i) == null) {
                System.out.print(" |");
            } else {
                System.out.print(TapeAlphabet[Tape.get(i) - 1] + "|");
            }
        }
        System.out.println("\n");
    }

    public int getHeadPos() {
        return HeadPos;
    }

    public int getTapeLength() {
        return TapeLength;
    }

    public void setTapeLength(int tapeLength) {
        TapeLength = tapeLength;
    }
}
