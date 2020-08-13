import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] gifts = scan.nextLine().split("\\s+");

        String input = scan.nextLine();
        while (!"No Money".equals(input)){
            String[] tokens = input.split("\\s+");
            String switchT = tokens[0];
            switch (switchT){
                case "OutOfStock":
                    String gift = tokens[1];
                    for (int i = 0; i < gifts.length ; i++) {
                        if (gift.equals(gifts[i])){
                            gifts[i] = "None";
                        }
                    }
                    break;
                case "Required":
                    gift = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index >=0 && index < gifts.length){
                        gifts[index] = gift;
                    }
                    break;
                case "JustInCase":
                    gift = tokens[1];
                    gifts[gifts.length - 1] = gift;
                    break;
            }

            input = scan.nextLine();
        }
        for(String gif : gifts){
            if (!"None".equals(gif)){
                System.out.print(gif + " ");
            }
        }
    }
}
