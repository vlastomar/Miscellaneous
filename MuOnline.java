import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dungRoom = scan.nextLine().split("\\|");
        int health = 100;
        int bitcoinsSum = 0;
        boolean dead = false;

        for (int i = 0; i < dungRoom.length; i++) {
                String input = dungRoom[i];
                String[] tokens = input.split("\\s+");
                String token = tokens[0];
                switch (token){
                    case "potion":
                        int heal = Integer.parseInt(tokens[1]);
                        int healed = 0;
                        if ((health + heal)> 100){
                            healed = 100 - health;
                            health = 100;
                        }else{
                            health += heal;
                            healed = heal;
                        }
                        System.out.printf("You healed for %d hp.%n", healed);
                        System.out.printf("Current health: %d hp.%n", health);
                        break;
                    case "chest":
                        int bitcoins = Integer.parseInt(tokens[1]);
                        System.out.printf("You found %d bitcoins.%n", bitcoins);
                        bitcoinsSum += bitcoins;
                        break;
                    default:
                        int attackM = Integer.parseInt(tokens[1]);
                        health -= attackM;
                        if (health > 0){
                            System.out.printf("You slayed %s.%n", tokens[0]);
                        }else{
                            System.out.printf("You died! Killed by %s.%n", tokens[0]);
                            System.out.printf("Best room: %d", i+1);
                            dead = true;
                        }
                        break;
                }
                if(dead){
                    break;
                }
        }
        if(!dead){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoinsSum);
            System.out.printf("Health: %d", health);

        }
    }
}
