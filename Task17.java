import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of ur next SDA class(yyyy.MM.dd): ");
        String dateOfSDAClass = scanner.nextLine();
            LocalDate nextClassDate = LocalDate.parse(dateOfSDAClass, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            LocalDate now = LocalDate.now();
            if (!nextClassDate.isAfter(now)) {
                System.out.println("You missed this one, better luck next time:)");
            } else {
                Period period = Period.between(now, nextClassDate);
                int daysUntilNextClass = period.getDays();
                System.out.println(daysUntilNextClass);
            }


    }



}
