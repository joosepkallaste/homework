import java.util.Scanner;

public class Scanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input float value: ");
        float floatValue = scanner.nextFloat();
        System.out.println("Please input byte value: ");
        byte byteValue = scanner.nextByte();
        System.out.println("Please input float value: ");
        char charValue = scanner.next(). charAt(0);
        System.out.println("You entered the float value: " + floatValue);
        System.out.println("You entered the byte value: " + byteValue);
        System.out.println("You entered the character: " + charValue);

    }
}
