import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstLetter = scanner.next().charAt(0);
        char lastLetter = scanner.next().charAt(0);
        int difference = -1;
        if (firstLetter < 'a'|| firstLetter > 'z' || lastLetter < 'a'|| lastLetter > 'z'){
            System.out.println("Please input lowercase letters.");
        } else {
            difference += (lastLetter - firstLetter);
            System.out.println(difference);

        }


    }
}
