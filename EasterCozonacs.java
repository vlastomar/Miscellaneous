import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double price1kgFloor = Double.parseDouble(scan.nextLine());

        double packEggs = price1kgFloor * 0.75;
        double price1lMilk = price1kgFloor * 1.25;
        double price1cozunak = price1kgFloor + packEggs + price1lMilk/4.0;

        int countCozunac = 0;
        int countColoredEggs = 0;

        while (budget >= price1cozunak){
            budget -= price1cozunak;
            countCozunac++;
            countColoredEggs += 3;
            if (countCozunac % 3 == 0){
                int lostEggs = countCozunac - 2;
                countColoredEggs -= lostEggs;
            }

        }
        System.out.printf("You made %d cozonacs! " +
                "Now you have %d eggs and %.2fBGN left.", countCozunac, countColoredEggs, budget );
    }
}
