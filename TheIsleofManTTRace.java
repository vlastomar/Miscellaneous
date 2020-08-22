import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleofManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        while (true){
            String input = scan.nextLine();
            Pattern patt = Pattern.compile("(\\#|\\$|\\%|\\*|\\&)(?<name>[A-Za-z]+)(\\1)=(?<code>\\d+)!!(?<ecode>.+)$");
            Matcher mat = patt.matcher(input);
           // boolean checkVlaid = true;
            boolean end = false;
            while (mat.find()){

                int number = Integer.parseInt(mat.group("code"));
                String message = mat.group("ecode");
                if (number == message.length()){
                    end = true;
                    String name = mat.group("name");
                    StringBuilder word = new StringBuilder(message);
                    for (int i = 0; i < word.length(); i++) {
                        int charInt = word.charAt(i) + number;
                        String newChar = (char)charInt + "";
                        word.replace(i, i+1, newChar);

                    }
                    System.out.println(String.format("Coordinates found! %s -> %s",name, word));
                }

            }
            if (end){
                break;
            }
            System.out.println("Nothing found!");
        }
    }
}
