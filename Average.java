import java.util.Scanner;
public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number: ");
        int input1 = scanner.nextInt();
        System.out.println("Please input number: ");
        int input2 = scanner.nextInt();
        System.out.println("Please input number: ");
        int input3 = scanner.nextInt();
        int var1 = ((input1 + input2 + input3)/3);
        System.out.println("Average = " + var1);


    }
}
