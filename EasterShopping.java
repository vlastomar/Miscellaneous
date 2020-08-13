import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shops = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] commands = scan.nextLine().split("\\s+");
            String token = commands[0];
            switch (token){
                case "Include":
                    String shop = commands[1];
                    shops.add(shop);
                    break;
                case "Visit":
                    String position = commands[1];
                    int numberShops = Integer.parseInt(commands[2]);
                    if (numberShops <= shops.size()){
                        if (position.equals("first")){
                            for (int j = 0; j <numberShops ; j++) {
                                shops.remove(0);
                            }

                        }else if ("last".equals(position)){
                            for (int j = 0; j < numberShops ; j++) {
                                shops.remove(shops.size() - 1);
                            }

                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commands[1]);
                    int index2 = Integer.parseInt(commands[2]);
                    if (index1 >= 0 && index1 < shops.size()
                     && index2 >=0 && index2 < shops.size()){
                        String temp = shops.get(index1);
                        shops.set(index1, shops.get(index2));
                        shops.set(index2, temp);
                    }
                    break;
                case "Place":
                    shop = commands[1];
                    index1 = Integer.parseInt(commands[2]);
                    if (index1 >= 0 && index1 + 1 < shops.size()){
                         shops.add(index1 + 1, shop);
                    }

                    break;
            }
        }
        System.out.println("Shops left:");
        for(String sh : shops){
            System.out.print(sh + " ");
        }
    }
}
