import java.util.Scanner;

public class Harmonic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double h = 0.0;
        for (int i = 1; i <= n; i ++){
            h += 1.0/i;
        }
        System.out.println(h);
    }
}
