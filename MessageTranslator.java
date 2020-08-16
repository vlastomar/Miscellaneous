
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();

            Pattern patt = Pattern.compile("\\!(?<command>[A-Z][\\w+]{3,})\\!\\:\\[(?<message>[A-Za-z]{8,})\\]");
            Matcher mat = patt.matcher(input);
            boolean check = true;

            while (mat.find()){
                check = false;
                String command = mat.group("command");
                String message = mat.group("message");
                System.out.print(String.format("%s: ", command));
                for (int j = 0; j < message.length() ; j++) {
                    int temp = (int) message.charAt(j);
                    System.out.print(String.format("%d ",temp ));
                }
                System.out.println();
            }
            if (check){
                System.out.println("The message is invalid");
            }

        }
    }
}
