import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double sum = 0.0;

        for (int i = 1; i <= days ; i++) {
            sum += dailyPlunder * 1.0;
            if (i % 3 == 0 ){
                sum += dailyPlunder * 0.50;
            }
            if (i % 5 == 0){
                sum = sum * 0.70;
            }
        }
        if (sum >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.%n", sum);
        }else{
            double temp = sum / expectedPlunder * 100.0;
            System.out.printf("Collected only %.2f%% of the plunder.", temp);
        }
    }
}
