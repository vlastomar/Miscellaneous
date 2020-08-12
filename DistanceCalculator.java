import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int steps =  Integer.parseInt(scan.nextLine());
        double long1StepCm = Double.parseDouble(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());

        double distanceCm = distance * 100.00;
        double sumDist = 0.0;

        for (int i = 1; i <= steps ; i++) {
            if (i % 5 == 0){
                sumDist += long1StepCm * 0.70;
            }else{
                sumDist += long1StepCm;
            }

        }
        System.out.printf("You travelled %.2f%% of the distance!", sumDist/distanceCm * 100.0);
    }
}
