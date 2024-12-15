import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Enough {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String longestText = "";
        boolean textProvided = false;


        // gets input from the user
        // stores them in an array
        // when enough is inputted the program chooses the longest input and prints it
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("No text provided.");
                continue;
            }
            if (input.equals("Enough!")) {
                break;
            }
            textProvided = true;
            if (input.length() > longestText.length()){
                longestText = input;
            }

        }
        if (textProvided) {
            System.out.println(longestText);
        } else {
            System.out.println("No text provided.");
        }
    }
}

