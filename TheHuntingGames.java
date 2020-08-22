import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int countPlayers = Integer.parseInt(scan.nextLine());
        double groupEnergy = Double.parseDouble(scan.nextLine());
        double waterPerDayOnePerson = Double.parseDouble(scan.nextLine());
        double foodPerDayOnePerson = Double.parseDouble(scan.nextLine());

        double currentWater = countPlayers * waterPerDayOnePerson * days;
        double currentFood = countPlayers * foodPerDayOnePerson * days;

        for (int i = 1; i <= days ; i++) {
            double lostEnergyDaily = Double.parseDouble(scan.nextLine());
            groupEnergy -= lostEnergyDaily;
            if (groupEnergy <= 0){
                break;
            }
            if (i % 2 == 0){
                groupEnergy = groupEnergy * 1.05;
                currentWater *=0.70;
            }
            if (i % 3 == 0){
                    currentFood -= currentFood/countPlayers;
                    groupEnergy = groupEnergy * 1.10;
            }

        }
        if (groupEnergy > 0){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        }else{
            System.out.printf("You will run out of energy. You will be left with " +
                    "%.2f food and %.2f water.", currentFood, currentWater);
        }

    }
}
