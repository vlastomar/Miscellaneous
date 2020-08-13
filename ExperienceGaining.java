import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scan.nextLine());
        int countBattles = Integer.parseInt(scan.nextLine());

        double sum = 0;
        int counter = 0;

        for (int i = 1; i <= countBattles ; i++) {
            double experienceBattle = Double.parseDouble(scan.nextLine());
            counter++;
            sum += experienceBattle;
            if (i % 3 == 0){
                sum += experienceBattle * 0.15;
            }
            if (i % 5 == 0){
                sum -= experienceBattle * 0.10;
            }
            if (sum >= neededExperience){
                break;
            }
        }
        if (sum >=  neededExperience){
            System.out.printf
                    ("Player successfully collected his needed experience for %d battles.", counter);
        }else {
            System.out.printf("Player was not able to collect the needed experience," +
                    " %.2f more needed.", neededExperience - sum);
        }
    }
}
