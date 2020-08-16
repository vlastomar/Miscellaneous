import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            boolean checkValid = true;
            Pattern patt = Pattern.compile("(\\*|\\@)(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<first>[A-Za-z])\\]\\|\\[(?<second>[A-Za-z])\\]\\|\\[(?<third>[A-Za-z])\\]\\|$");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                checkValid = false;
                String tag = mat.group("tag");

                int first = (int) mat.group("first").charAt(0);
                int second =(int)  mat.group("second").charAt(0);
                int third = (int) mat.group("third").charAt(0);
                System.out.println(String.format("%s: %d %d %d", tag, first, second, third));

            }
            if (checkValid){
                System.out.println("Valid message not found!");
            }
        }
    }
}
