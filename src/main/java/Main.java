import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        // Load gödel numbers and store all user inputs
        System.out.print("Choose one TM by entering its line number in the file \"goedelnumber.txt\": \n> ");
        Scanner scan = new Scanner(System.in);
        int targetLineNum = scan.next().trim().charAt(0) - '0';
        String targetLine = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Turing_Machine/src/main/resources/goedelnumber.txt"))) {
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine == targetLineNum - 1) {
                    targetLine = line;
                }
                currentLine++;
            }
        }
        System.out.print("TM initialized\n\n1. Run-Modus\n2. Step-Modus\nEnter a modus to proceed:\n> ");
        int modus = scan.next().trim().charAt(0) - '0';
        int speed = 0;
        if(modus == 2){
            System.out.print("Enter desired calculation step speed (unit = millisecond): \n> ");
            speed = Integer.parseInt(scan.next().trim());
        }
        System.out.print("Enter your input for calculation:\n> ");
        String input = scan.next().trim();
        System.out.println("");

        // Initialize the turing machine with chosen gödel number
        TuringMachine TM = new TuringMachine();
        TM.parse(targetLine);

        // Run Calculation
        TM.setCalcSpeed(speed);
        if (TM.calculate(input, modus)) {
            TM.getTape().showTape();
            System.out.println("input word ACCEPTED");
        } else {
            TM.getTape().showTape();
            System.out.println("input word REJECTED");
        }
        System.out.println("Number of total calculation steps: " + TM.getCounter());
    }
}
