
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> healths = new TreeMap<>();
        Map<String, Integer> energys = new TreeMap<>();


        String input = scan.nextLine();
        while (!"Results".equals(input)){
            String[] token = input.split(":");
            String command = token[0];
            switch (command){
                case "Add":
                    String name = token[1];
                    int health = Integer.parseInt(token[2]);
                    int energy = Integer.parseInt(token[3]);
                    healths.putIfAbsent(name, 0);
                    healths.put(name, healths.get(name) + health);
                    energys.putIfAbsent(name, 0);
                    energys.put(name, energy);
                    break;
                case "Attack":
                    String attacker = token[1];
                    String defender = token[2];
                    int damage = Integer.parseInt(token[3]);
                    if (healths.containsKey(attacker) && healths.containsKey(defender)){
                        healths.put(defender, healths.get(defender) - damage);
                        if (healths.get(defender) <= 0){
                            System.out.println(String.format("%s was disqualified!", defender));
                            healths.remove(defender);
                            energys.remove(defender);
                        }
                        energys.put(attacker, energys.get(attacker) - 1);
                        if (energys.get(attacker) <= 0){
                            System.out.printf("%s was disqualified!\n", attacker);
                            healths.remove(attacker);
                            energys.remove(attacker);
                        }
                    }
                    break;
                case "Delete":
                    name = token[1];
                    if ("All".equals(name)){
                        healths = new TreeMap<>();
                        energys = new TreeMap<>();
                    }else if(healths.containsKey(name)){
                        healths.remove(name);
                        energys.remove(name);
                }
                    break;
            }

            input = scan.nextLine();
        }


        System.out.println(String.format("People count: %d", healths.size()));
        Map<String, Integer> finalEnergys = energys;
        healths.entrySet().stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(p -> {
                    System.out.println(String.format("%s - %d - %d", p.getKey(), p.getValue(), finalEnergys.get(p.getKey()) ));
                });

    }
}
