import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int remainEnergy = Integer.parseInt(scan.nextLine());
        int wontCounter = 0;

        while (true) {
            String input = scan.nextLine();
            if ("End of battle".equals(input)){
                System.out.printf("Won battles: %d. Energy left: %d", wontCounter, remainEnergy);
                break;
            }
            int dist = Integer.parseInt(input);
            remainEnergy = remainEnergy - dist;
            wontCounter ++;

            if (remainEnergy < 0 ){
                remainEnergy = remainEnergy + dist;
                wontCounter = wontCounter - 1;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        wontCounter, remainEnergy);
                break;
            }
            if (wontCounter % 3 == 0){
                remainEnergy = remainEnergy + wontCounter;
            }
        }
    }
}
