import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String newText = "";
        String[] words = userInput.split(" ");
        for (String word : words) {
            newText += (word + " " + word + " ");

        }

        System.out.println(newText.trim());


    }
}
