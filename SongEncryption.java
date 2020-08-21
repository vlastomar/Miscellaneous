import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!"end".equals(input)) {
            Pattern patt = Pattern.compile("^(?<artist>[A-Z][a-z\\'\\ ]+):(?<song>[A-Z ]+)");
            Matcher mat = patt.matcher(input);
            boolean chckValid = true;
            while (mat.find()) {
                chckValid = false;
                int key = mat.group("artist").length();
                StringBuilder word = new StringBuilder(input);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == ':') {
                        int index = word.indexOf(":");
                        word.replace(index, index + 1, "@");
                    } else if (word.charAt(i) != ' ' && word.charAt(i) != '\'') {
                        if (word.charAt(i) < 91 && word.charAt(i) > 64) {
                            int charInt = word.charAt(i) + key;
                            if (charInt > 90) {
                                charInt = charInt - 26;
                            }
                                String temp = (char) charInt + "";
                                //String oldChar = word.charAt(i) + "";
                                //int index = word.indexOf(oldChar);
                                word.replace(i, i + 1, temp);


                        } else if (word.charAt(i) < 123 && word.charAt(i) > 96) {
                            int charInt = word.charAt(i) + key;
                            if (charInt > 122) {
                                charInt = charInt - 26;
                            }
                                String temp = (char) charInt + "";
                                //String oldChar = word.charAt(i) + "";
                                //int index = word.indexOf(oldChar);
                                word.replace(i, i + 1, temp);
                        }
                    }
                }
                System.out.println(String.format("Successful encryption: %s", word));




            }
            if (chckValid) {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }
}
