import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers =  scanner.nextInt();
        for (int i = 1; i <= numbers; i ++){
            if (i % 3 == 0){
                System.out.println("Fizz");
            } else if (i%7 == 0){
                System.out.println("Buzz");

            } else {
                System.out.println(i);
            }
        }
    }
}
