import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
//        System.out.print("Choose desired TM:\n> ");
//        Scanner scanInput = new Scanner(System.in);
//        String input = scanInput.next();
//        int inputInt = input.trim().charAt(0) - '0';
//
//        ArrayList<String> goedelnumbers = new ArrayList<>();
//        String desiredTM = "";
//        try {
//            File TM = new File("Turing_Machine/src/main/resources/goedelnumber.txt");
//            Scanner fileReader = new Scanner(TM);
//            while(fileReader.hasNextLine()) {
//                goedelnumbers.add(fileReader.nextLine());
//            }
//            while (inputInt > goedelnumbers.size()){
//                System.out.println("Enter a valid Number.");
//            }
//            desiredTM = goedelnumbers.get(inputInt);
//            fileReader.close();
//            scanInput.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }

        System.out.print("Enter your goedelnumber: \n> ");
        Scanner scan = new Scanner(System.in);
        String UserTM = scan.next();
        TuringMachine TM = new TuringMachine();
        TM.parse(UserTM);
        TM.getTransitionMapping();
    }
}
