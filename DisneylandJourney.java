import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double costJourney = Double.parseDouble(scan.nextLine());
        double months = Double.parseDouble(scan.nextLine());

        double sum = 0;

        for (int i = 1; i <= months ; i++) {

            if (i % 2 != 0 && i > 1){
                sum -= sum * 0.16;
            }
            if (i % 4 == 0){
                sum += sum * 0.25;
            }
            sum += costJourney * 0.25;
        }
        if (sum >= costJourney){
            double souvenirs = sum - costJourney;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", souvenirs);
        }else {
            double need = costJourney - sum;
            System.out.printf("Sorry. You need %.2flv. more.", need);
        }
    }
}
