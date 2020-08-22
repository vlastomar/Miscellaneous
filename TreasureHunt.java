import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        List<String> stealed = new ArrayList<>();

        String input = scan.nextLine();
        while (!"Yohoho!".equals(input)){
            String[] tokens = input.split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Loot":
                    for (int i = 1; i < tokens.length ; i++) {
                        String temp = tokens[i];
                        if (!initialLoot.contains(temp)){
                            initialLoot.add(0, temp);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < initialLoot.size()) {
                    String temp = initialLoot.get(index);
                    initialLoot.remove(temp);
                    initialLoot.add(temp);
                    }
                    break;
                case "Steal" :
                    int count = Integer.parseInt(tokens[1]);
                    if (count > initialLoot.size()){
                        count = initialLoot.size();
                    }
                    for (int i = 0; i < count ; i++) {
                        stealed.add(0, initialLoot.get(initialLoot.size() -1));
                        initialLoot.remove(initialLoot.size() - 1);
                    }
                    for (int i = 0; i < stealed.size() ; i++) {
                        System.out.print(stealed.get(i));
                        if (i < stealed.size() - 1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    stealed.clear();
                    break;
            }

            input = scan.nextLine();
        }
        int sum = 0;
        if (initialLoot.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else{
            for (int i = 0; i < initialLoot.size(); i++) {
                String temp = initialLoot.get(i);
                sum += temp.length();
            }
            double tempCal = sum * 1.00 / initialLoot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", tempCal);
        }

    }
}
