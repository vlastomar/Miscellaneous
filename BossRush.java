import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            boolean checkValid = true;
            Pattern patt = Pattern.compile("\\|(?<boss>[A-Z]{4,})\\|\\:\\#(?<title>[A-Za-z]+ [A-Za-z]+)\\#");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                checkValid = false;
                String boss = mat.group("boss");
                String title = mat.group("title");
                System.out.println(String.format("%s, The %s\n>> Strength: %d\n>> Armour: %d", boss, title, boss.length(), title.length() ));

            }
            if (checkValid){
                System.out.println("Access denied!");
            }
        }
    }
}
