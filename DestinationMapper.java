import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> dests = new ArrayList<>();

        String input = scan.nextLine();
        Pattern patt = Pattern.compile("(=|\\/)(?<dest>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher mat = patt.matcher(input);
        int travelPoints = 0;
        System.out.print("Destinations: ");
        while (mat.find()){
            String destination = mat.group("dest");
            travelPoints += destination.length();
            dests.add(destination);


        }
        for (int i = 0; i < dests.size() ; i++) {
            if (i < dests.size() -1){

                System.out.print(dests.get(i) + ", ");
            }else{
                System.out.print(dests.get(i));
            }

        }
        System.out.println();
        System.out.println(String.format("Travel Points: %d", travelPoints));

    }
}
