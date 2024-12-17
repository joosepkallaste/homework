import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regularExpression = "achoo*o";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(text);


        if (matcher.find()){
            System.out.println("Bless you!");
        } else {
            System.out.println("No sneeze detected");
        }


    }
}
