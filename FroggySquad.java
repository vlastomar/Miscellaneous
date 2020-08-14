import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> namesFrogs = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        boolean exit = false;
        while (true){
            String[] tokens = scan.nextLine().split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Join":
                    String name = tokens[1];
                    if (!namesFrogs.contains(name)){
                        namesFrogs.add(name);
                    }
                    break;
                case "Jump":
                    name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < namesFrogs.size()){
                        namesFrogs.add(index, name);
                    }
                    break;
                case "Dive":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < namesFrogs.size()){
                        namesFrogs.remove(index);
                    }
                    break;
                case "First":
                    int count = Integer.parseInt(tokens[1]);
                    if (count > namesFrogs.size()){
                        count = namesFrogs.size();
                    }
                    for (int i = 0; i < count ; i++) {
                        System.out.print(namesFrogs.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case "Last":
                    count = Integer.parseInt(tokens[1]);
                    if (count > namesFrogs.size()){
                        count = namesFrogs.size();
                    }
                    int temp = namesFrogs.size() - count;
                    int temp1 = namesFrogs.size();
                    for (int i = temp; i < temp1 ; i++) {
                        System.out.print(namesFrogs.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case "Print":
                    String option = tokens[1];
                    System.out.print("Frogs: ");
                    if ("Normal".equals(option)){
                        for (String nam : namesFrogs){
                            System.out.print(nam + " ");
                        }
                    }else if ("Reversed".equals(option)){
                        for (int i = namesFrogs.size() - 1; i >= 0; i--) {
                            System.out.print(namesFrogs.get(i) + " ");
                        }
                    }
                    exit = true;
                    break;
            }
            if (exit){
                break;
            }
        }
    }
}
