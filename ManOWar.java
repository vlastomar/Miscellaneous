import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warship = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();
        boolean exit = false;
        boolean pirateSunk = false;
        while (!"Retire".equals(input)){

            String[] tokens = input.split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < warship.length) {
                        warship[index] = warship[index] - damage;
                        if (warship[index] <= 0) {
                            exit = true;
                        }
                    }
                    break;
                case "Defend":
                    index = Integer.parseInt(tokens[1]);
                   int index2 = Integer.parseInt(tokens[2]);
                   damage = Integer.parseInt(tokens[3]);
                   if (index >= 0 && index < pirateShip.length &&
                      index2 >= 0 && index2 < pirateShip.length){
                       for (int i = index; i <= index2 ; i++) {
                            pirateShip[i] = pirateShip[i] - damage;
                            if (pirateShip[i] <= 0){
                                pirateSunk = true;
                                break;
                            }
                       }

                   }
                    break;
                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int rep = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < pirateShip.length){
                        pirateShip[index] = pirateShip[index] + rep;
                        if (pirateShip[index] > maxHealth){
                            pirateShip[index] = maxHealth;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for(int pirat : pirateShip){
                        if (pirat < maxHealth * 0.2){
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
                }
            if (exit){
                System.out.println("You won! The enemy ship has sunken.");
                break;
            }else if (pirateSunk){
                System.out.println("You lost! The pirate ship has sunken.");
                break;
            }
            input = scan.nextLine();
        }
        if (!exit && !pirateSunk){
            int sumPirate = 0;
            int sumWar = 0;

            for (int pir : pirateShip){
                sumPirate += pir;
            }
            for (int war : warship){
                sumWar += war;
            }
            System.out.printf("Pirate ship status: %d%n", sumPirate);
            System.out.printf("Warship status: %d%n", sumWar);
        }


    }
}
