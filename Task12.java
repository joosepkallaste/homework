import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String withoutSpaces = text.replaceAll(" ", "");
        int spacesLength = text.length() - withoutSpaces.length();
        double percent = (spacesLength * 100.00) / text.length();
        System.out.println(percent);
    }
}
