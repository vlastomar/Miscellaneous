import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            boolean checkValid = true;
            Pattern patt = Pattern.compile("U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[0-9]+)P@\\$");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                String username = mat.group("username");
                String password = mat.group("password");
                count++;
                checkValid = false;
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s", username, password));
            }
            if (checkValid){
                System.out.println("Invalid username or password");
            }

        }
        System.out.println(String.format("Successful registrations: %d", count));

    }
}
