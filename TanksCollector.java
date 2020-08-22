import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> ownedPremiumVehicles = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] tokens = scan.nextLine().split(", ");

            switch (tokens[0]){
                case "Add":
                    String tankname = tokens[1];
                    if (ownedPremiumVehicles.contains(tankname)){
                        System.out.println("Tank is already bought");
                    }else{
                        ownedPremiumVehicles.add(tankname);
                        System.out.println("Tank successfully bought");
                    }
                    break;
                case "Remove":
                    tankname = tokens[1];
                    if (ownedPremiumVehicles.contains(tankname)){
                        ownedPremiumVehicles.remove(tankname);
                        System.out.println("Tank successfully sold");
                    }else{
                        System.out.println("Tank not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < ownedPremiumVehicles.size()){
                        System.out.println("Tank successfully sold");
                        ownedPremiumVehicles.remove(index);
                    }else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    tankname = tokens[2];
                    if (index >= 0 && index < ownedPremiumVehicles.size()){
                        if (ownedPremiumVehicles.contains(tankname)){
                            System.out.println("Tank is already bought");
                        }else{
                            ownedPremiumVehicles.add(index, tankname);
                            System.out.println("Tank successfully bought");
                        }
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;

            }
        }
        for (int i = 0; i < ownedPremiumVehicles.size() ; i++) {
            System.out.print(ownedPremiumVehicles.get(i));
            if (i < ownedPremiumVehicles.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
