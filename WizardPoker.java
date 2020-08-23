import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> allCards = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());
        List<String> ourCards = new ArrayList<>();

        String input = scan.nextLine();
        while (!"Ready".equals(input)){
            String[] tokens = input.split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Add":
                    String card = tokens[1];
                    if (allCards.contains(card)){
                        ourCards.add(card);
                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    card = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (allCards.contains(card) && index >= 0 && index <ourCards.size()){
                        ourCards.add(index, card);
                    }else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    card = tokens[1];
                    if (ourCards.contains(card)){
                        ourCards.remove(card);

                    }else{
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    card = tokens[1];
                    String card2 = tokens[2];
                    if (ourCards.contains(card) && ourCards.contains(card2)){
                        int index1 = ourCards.indexOf(card);
                        int index2 = ourCards.indexOf(card2);
                        String temp = ourCards.get(index1);
                        ourCards.set(index1, ourCards.get(index2));
                        ourCards.set(index2, temp);
                    }
                    break;
                case "Shuffle":
                    for (int i = 0; i < ourCards.size()/2 ; i++) {
                        String temp = ourCards.get(ourCards.size() - 1 - i);
                        ourCards.set(ourCards.size() - 1 - i, ourCards.get(i));
                        ourCards.set(i, temp);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for(String card : ourCards){
            System.out.print(card + " ");
        }
    }
}
