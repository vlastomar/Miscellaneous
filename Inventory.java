import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> journal = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"Craft!".equals(input)){
            String[] tokens = input.split(" - ");
            String token = tokens[0];
            switch (token){
                case "Collect":
                    String item = tokens[1];
                    if (!journal.contains(item)){
                        journal.add(item);
                    }
                    break;
                case "Drop":
                    item = tokens[1];
                    if (journal.contains(item)){
                        journal.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] temp = tokens[1].split(":");
                    if (journal.contains(temp[0])){
                        int index = journal.indexOf(temp[0]);
                        journal.add(index+1,temp[1]);
                    }
                    break;
                case "Renew":
                    item = tokens[1];
                    if (journal.contains(item)){
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < journal.size() ; i++) {
            System.out.print(journal.get(i));
            if (i < journal.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
