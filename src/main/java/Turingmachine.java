import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turingmachine {
    Map<SourceFunction, ImageFunction> Transitions = new HashMap<>();
    ArrayList<Integer> TapeContent = new ArrayList<>();
    int InputWord = 0;
    int Counter = 0;
    int HeadPosition = 0;

    public Turingmachine(String goedelnummer){
        parser(goedelnummer);
    }

    public int calculate(){
        return 0;
    }

    /**
     * Set all transition functions for the TM
     * @param goedNum the input that should be parsed and interpreted as transition functions
     * return true if parser completes successfully, false if the goedNum is invalid
     */
    public boolean parser(String goedNum){

        String[] parsedTransitions = goedNum.split("11"); // Store each transition as one element
        for (int i = 0; i < parsedTransitions.length; i++){
            String[] parsedZeros = parsedTransitions[i].split("1");
            if (parsedZeros.length != 5) {
                System.out.println("Invalid goedelnumber.");
                return false;
            }
            Transitions.put(
                    new SourceFunction(parsedZeros[0].length(), parsedZeros[1].length()),
                    new ImageFunction(parsedZeros[2].length(), parsedZeros[3].length(), parsedZeros[4].length())
            );
        }

        return true;
    }

    public int nextState(){
        return 0;
    }
}
