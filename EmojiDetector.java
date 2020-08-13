import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<String> emojies = new ArrayList<>();

        BigInteger coolThreshold = new BigInteger("1");
        Pattern patt = Pattern.compile("[0-9]");
        Matcher mat = patt.matcher(input);
        while (mat.find()){
            int find = Integer.parseInt(mat.group());
           coolThreshold = coolThreshold.multiply(BigInteger.valueOf(find));
        }
        patt = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)");
        mat = patt.matcher(input);
        int count = 0;
        while (mat.find()){
            String emoji = mat.group("emoji");
            String emojiAndSymbols =  mat.group();
            count++;
            int sum = 0;
            for (int i = 0; i < emoji.length() ; i++) {
                int temp = (int)emoji.charAt(i);
                sum += temp;
            }
            BigInteger sumB = BigInteger.valueOf(sum);
            if (sumB.compareTo(coolThreshold) > 0){
                emojies.add(emojiAndSymbols);
            }
        }
        System.out.println(String.format("Cool threshold: %d", coolThreshold));
        System.out.println(String.format("%d emojis found in the text. The cool ones are:", count));
        for(String em : emojies){
            System.out.println(em);
        }

    }
}
