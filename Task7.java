import java.util.Scanner;

public class Fibanochhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();


        if (index == 1 || index == 2) {
            System.out.println(1);
            return;
        }

        int a = 1, b = 1;
        for (int i = 3; i <= index; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println(b);
    }
}
