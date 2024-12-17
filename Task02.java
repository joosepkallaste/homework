import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter weight in kg: ");
        float weight = scanner.nextFloat();
        System.out.println("Please enter height in cm: ");
        int height = scanner.nextInt();
        double height1 = height/100.00;
        double heightsqr = (Math.pow(height1, 2));
        double bmi = weight / heightsqr;
        if (bmi > 18.5 && bmi < 24.9) {
            System.out.println("BMI optimal");
        } else {
            System.out.println("BMI not optimal");
        }
    }
}
