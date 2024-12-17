import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 2){
            System.out.println(number);
        }
        if (number == 3){
            System.out.println(number);
        }
        for (int i = 4; i > number; i ++){
            if (i%2 != 0 || i%3 != 0){
                System.out.println(i);
            }
        }
    }
}
