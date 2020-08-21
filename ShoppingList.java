import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());

        while (true){
            String[] commands = scan.nextLine().split(" ");
            if ("Go".equals(commands[0])){
                for (int i = 0; i < groceries.size() ; i++) {
                    System.out.print(groceries.get(i));
                    if (i < groceries.size() - 1){
                        System.out.print(", ");
                    }

                }
                break;
            }

            switch (commands[0]){
                case "Urgent":
                    if (!groceries.contains(commands[1])){
                        groceries.add(0, commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(commands[1])){
                        groceries.remove(commands[1]);
                    }
                    break;
                case "Correct":
                    int temp = 0;
                    if (groceries.contains(commands[1])){
                        for (int i = 0; i < groceries.size(); i++){
                            if (commands[1].equals(groceries.get(i))){
                                temp = i;
                            }
                        }
                        groceries.set(temp, commands[2]);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(commands[1])){
                        groceries.remove(commands[1]);
                        groceries.add(commands[1]);
                    }
                    break;
            }
        }
    }
}
