import java.util.Random;
import java.util.Scanner;

public class Task20 {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        boolean numberProvided = false;
        while (true) {
            int unum = scanner.nextInt();
            if (unum == num) {
                System.out.println("Congratulations!");
                break;
            } else if (unum > num) {
                System.out.println("too much");
            } else if (unum < num) {
                System.out.println("not enough");
            }
        }

    }
}
