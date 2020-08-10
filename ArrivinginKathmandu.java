import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivinginKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!"Last note".equals(input)){
            boolean checkValid = true;
            Pattern patt = Pattern.compile("(?<name>[A-Za-z\\!\\@\\#\\$\\?\\d]+)=(?<gcode>\\d+)<<(?<code>.{5,})$");
            Matcher mat = patt.matcher(input);
            while (mat.find()){
                String name = mat.group("name");
                int gcode = Integer.parseInt(mat.group("gcode"));
                String code = mat.group("code");
                if (gcode == code.length()){
                    String realName = "";
                    checkValid = false;
                    Pattern pat1 = Pattern.compile("[A-Za-z]");
                    Matcher mat1 = pat1.matcher(name);
                    while (mat1.find()){
                        realName += mat1.group();
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", realName, code));
                }
            }


            if (checkValid){
                System.out.println("Nothing found!");
            }
            input = scan.nextLine();
        }
    }
}
