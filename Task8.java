import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float number1 = scanner.nextFloat();
        char operator = scanner.next().charAt(0);
        float number2 = scanner.nextFloat();
        float result = 0;
        boolean validOperation = true;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                validOperation = false;
        }

        // Print the result if the operation was valid
        if (validOperation) {
            System.out.println("Result: " + result);
        }
    }
}
