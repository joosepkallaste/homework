import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double delta = (Math.pow(b, 2.0)- 4*a*c);
        double x1 = (-b - (Math.sqrt(delta)))/(2*a);
        double x2 = (-b + (Math.sqrt(delta)))/(2*a);

        System.out.println(x1);
        System.out.println(x2);



    }
}
