
public class Main {
    public static void main (String[] args){
        System.out.println("test");
        String Input = "010010001010011000101010010110001001001010011000100010001010";
        TuringMachine TM = new TuringMachine();
        TM.parse(Input);
    }
}
