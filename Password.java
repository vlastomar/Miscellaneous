import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            boolean checkValid = true;
            String input = scan.nextLine();
            Pattern patt = Pattern.compile("(.+)>(?<first>[0-9]+)\\|(?<second>[a-z]+)\\|(?<third>[A-Z]+)\\|(?<fourth>[^\\<\\>]+)<(\\1)$");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                checkValid = false;
                String passWord = mat.group("first") + mat.group("second")
                        + mat.group("third") + mat.group("fourth");
                System.out.println("Password: " + passWord);

            }
            if (checkValid){
                System.out.println("Try another password!");
            }
        }
    }
}
