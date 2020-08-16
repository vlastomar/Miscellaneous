import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> equalStrings = new LinkedHashMap<>();
        int count = 0;
        boolean check = false;

        String input = scan.nextLine();
        Pattern patt = Pattern.compile("(@|#)(?<first>[A-Za-z]{3,})(\\1)(\\1)(?<second>[A-Za-z]{3,})(\\1)");
        Matcher mat = patt.matcher(input);
        if (!mat.find()){
            System.out.println("No word pairs found!");
        }else{
            patt = Pattern.compile("(@|#)(?<first>[A-Za-z]{3,})(\\1)(\\1)(?<second>[A-Za-z]{3,})(\\1)");
            mat = patt.matcher(input);
            while (mat.find()){
                check = true;
                count++;
                String first = mat.group("first");
                String second = mat.group("second");
                // claculations(first, second, equalStrings);
                StringBuilder temp1 = new StringBuilder(second);
                String reversedSecond = temp1.reverse().toString();
                if (reversedSecond.equals(first)){
                    equalStrings.putIfAbsent(first, "");
                    equalStrings.put(first, second);
                }
            }
        }

        if (equalStrings.isEmpty()){
            if (check) {
                System.out.println(String.format("%d word pairs found!", count));
            }
            System.out.println("No mirror words!");
        }else{
            System.out.println(String.format("%d word pairs found!", count));
            System.out.println("The mirror words are:");
            int[] counter = {1};
            equalStrings
                    .entrySet()
                    .forEach(f -> {
                        System.out.print(String.format("%s <=> %s", f.getKey(), f.getValue()));
                        if (counter[0] < equalStrings.size()){
                            System.out.print(", ");
                        }
                        counter[0]++;
                    });
        }
    }
    /*public static void claculations (String first , String second, LinkedHashMap<String, String> equalStrings){
        StringBuilder temp = new StringBuilder(second);
        temp = temp.reverse();
        if (temp.toString().equals(first)){
            equalStrings.putIfAbsent(first, "");
            equalStrings.put(first, second);

        }

    }*/
}