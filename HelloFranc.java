import java.util.Scanner;

public class HelloFranc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] items = scan.nextLine().split("\\|");
        double budget = Double.parseDouble(scan.nextLine());
        double initialBudget = budget;

        double profit = 0.0;

        for (int i = 0; i <items.length ; i++) {

            String[] oneItem = items[i].split("->");
            double priceOneItem = Double.parseDouble(oneItem[1]);
            switch (oneItem[0]){
                case "Clothes":
                    if (priceOneItem <= 50.0 && budget >= priceOneItem){
                        double temp = priceOneItem * 1.40;
                        System.out.printf("%.2f ", temp);
                        profit += temp - priceOneItem;
                        budget -= priceOneItem;
                    }
                    break;
                case "Shoes":
                    if (priceOneItem <= 35.0 && budget >= priceOneItem){
                        double temp = priceOneItem * 1.40;
                        System.out.printf("%.2f ", temp);
                        profit += temp - priceOneItem;
                        budget -= priceOneItem;
                    }
                    break;
                case "Accessories":
                    if (priceOneItem <= 20.50 && budget >= priceOneItem){
                        double temp = priceOneItem * 1.40;
                        System.out.printf("%.2f ", temp);
                        profit += temp - priceOneItem;
                        budget -= priceOneItem;
                    }
                    break;
            }
        }
        System.out.println();
        System.out.printf("Profit: %.2f%n", profit);
        budget = initialBudget + profit;
        if (budget >= 150){
            System.out.println("Hello, France!");
        }else{
            System.out.println("Time to go.");
        }
    }
}
