import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scan.nextLine());
        for (int i = 0; i < word.length(); i++) {
            char encr = word.charAt(i);
            encr = (char)(encr - 3);
            String temp = encr + "";
            word.replace(i, i+1, temp);
        }
        String[] letters = scan.nextLine().split("\\s+");
        String replaceAll = word.toString().replaceAll(letters[0], letters[1]);
        word = new StringBuilder(replaceAll);
        Pattern patt = Pattern.compile("^[d-z\\{\\}\\|\\#][a-z\\{\\}\\|\\# ]+");
        Matcher mat = patt.matcher(word);
        boolean checkValid = true;
        while (mat.find()){
            System.out.print(mat.group());
            checkValid = false;
        }
        if (checkValid){
            System.out.println("This is not the book you are looking for.");
        }

    }
}
