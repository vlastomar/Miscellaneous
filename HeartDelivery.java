import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] neighborhood = Arrays.stream(scan.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        int step = 0;
        int counter = 0;

        while (true){
            String[] action = scan.nextLine().split(" ");
            if ("Love!".equals(action[0])){
                System.out.printf("Cupid's last position was %d.%n", step);
                for (int i = 0; i <neighborhood.length ; i++) {
                    if (neighborhood[i] != 0){
                        counter++;
                    }
                }
                if (counter == 0){
                    System.out.println("Mission was successful.");
                }else{
                    System.out.printf("Cupid has failed %d places.", counter);
                }

                break;
            }
            int jump = Integer.parseInt(action[1]);
            if ((step + jump) >= neighborhood.length) {
                if (neighborhood[0] > 0){
                    neighborhood[0] -= 2;
                    if (neighborhood[0] <= 0) {
                        System.out.println("Place 0 has Valentine's day.");
                    }
                } else{
                    System.out.println("Place 0 already had Valentine's day.");
                }
                step = 0;
            }else if (neighborhood[step + jump] > 0){
                neighborhood[step + jump] -= 2;
                if (neighborhood[step + jump] <= 0) {
                    System.out.printf("Place %d has Valentine's day.%n", step + jump);
                }
                step += jump;
            } else if (neighborhood[step + jump] <= 0){
                System.out.printf("Place %d already had Valentine's day.%n", step+jump);
                step += jump;
            }
        }

    }
}
