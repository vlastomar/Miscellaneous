import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            boolean checkValid = true;
            Pattern patt = Pattern.compile("^(\\$|\\%)(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                checkValid = false;
                String tag = mat.group("tag");
                String first = Character.toString((char)Integer.parseInt(mat.group("first"))) ;
                String second = Character.toString((char)Integer.parseInt(mat.group("second"))) ;
                char third = (char) Integer.parseInt(mat.group("third"));
                String message =  first + second + third + "";
                System.out.println(String.format("%s: %s", tag, message));

            }

            if (checkValid){
                System.out.println("Valid message not found!");
            }

        }
    }
}
