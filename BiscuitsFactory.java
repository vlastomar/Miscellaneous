import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int biscuits = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        int anotherComp = Integer.parseInt(scan.nextLine());
        int sum = 0;


        for (int i = 1; i <= 30 ; i++) {

            double temp = biscuits * workers * 1.0;
            if (i % 3 == 0){
                temp *= 0.75;
                temp = Math.floor(temp);


            }
            sum += (int)temp;
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", sum);
        if (sum > anotherComp){
            double pct = (sum - anotherComp) * 100.0/anotherComp ;
            System.out.printf("You produce %.2f percent more biscuits.", pct);
        }else if (sum < anotherComp){
            double pct = (anotherComp - sum) * 100.0 / anotherComp ;
            System.out.printf("You produce %.2f percent less biscuits.", pct);
        }
    }
}
