
public class Main {
    public static void main (String[] args){
        System.out.println("test");
        String Input1 = "010010001010011000101010010110001001001010011000100010001010";
        String Input2 = "1010010100100110101000101001100010010100100110001010010100";
        TuringMachine TM = new TuringMachine();
        TM.parse(Input1);
        TM.parse(Input2);
    }
}
