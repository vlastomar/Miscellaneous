import java.util.Arrays;
import java.util.Scanner;

public class ShootForWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int counter = 0;
        while (true){
            String index = scan.nextLine();

            if ("End".equals(index)){

                System.out.printf("Shot targets: %d -> ", counter);
                for(int num : targets){
                    System.out.print(num + " ");
                }
                break;
            }
            int indexNumber = Integer.parseInt(index);
            if (indexNumber >= 0 && indexNumber < targets.length){
                int temp = targets[indexNumber];
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] > 0){
                      if (i == indexNumber){
                          targets[i] = -1;
                          counter ++;
                      }else if (targets[i] > temp){
                          targets[i] -= temp;
                      }else if (targets[i] <= temp && targets[i] >= 0){
                          targets[i] += temp;
                      }

                    }
                }
            }

        }
    }
}
