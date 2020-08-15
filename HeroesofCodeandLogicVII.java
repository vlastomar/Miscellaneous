import java.util.Scanner;
import java.util.TreeMap;

public class HeroesofCodeandLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        TreeMap<String, Integer> firstData = new TreeMap<>();
        TreeMap<String, Integer> secondData =  new TreeMap<>();

        for (int i = 0; i < number ; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int hp = Integer.parseInt(data[1]);
            int mp = Integer.parseInt(data[2]);
            firstData.putIfAbsent(name, 0);
            secondData.putIfAbsent(name, 0);
            if (hp > 100){
                hp = 100;
                firstData.put(name, hp);
            }else if (hp>= 0){
                firstData.put(name, hp);
            }
            if (mp > 200){
                mp = 200;
                secondData.put(name, mp);
            }else if (mp >= 0){
                secondData.put(name, mp);
            }

        }

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] command = input.split("\\s*\\-\\s*");
            String token = command[0];
            switch (token){
                case "CastSpell":
                    String name = command[1];
                    int mp = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    if (mp >= 0) {
                        if (secondData.get(name) >= mp) {
                            int temp = secondData.get(name) - mp;
                            secondData.put(name, temp);
                            System.out.printf("%s has successfully cast %s and now has %d MP!\n", name, spellName, temp);
                        } else {
                            System.out.printf("%s does not have enough MP to cast %s!\n", name, spellName);
                        }
                    }

                    break;
                case "TakeDamage":
                    name = command[1];
                    int hp = Integer.parseInt(command[2]);
                    if (hp >= 0 ) {
                        spellName = command[3];
                        int damage = firstData.get(name) - hp;
                        if (damage > 0) {
                            firstData.put(name, damage);
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", name, hp, spellName, damage);
                        } else {
                            firstData.remove(name);
                            secondData.remove(name);
                            System.out.printf("%s has been killed by %s!\n", name, spellName);
                        }
                    }
                    break;
                case "Recharge":
                    name = command[1];
                    mp = Integer.parseInt(command[2]);
                    if (mp >= 0) {
                        if (mp + secondData.get(name) > 200) {
                            mp = 200;
                            System.out.printf("%s recharged for %d MP!\n", name, 200 - secondData.get(name));
                            secondData.put(name, mp);
                        } else {
                            int temp = mp + secondData.get(name);
                            secondData.put(name, temp);
                            System.out.printf("%s recharged for %d MP!\n", name, mp);
                        }
                    }

                    break;
                case "Heal":
                    name = command[1];
                    hp = Integer.parseInt(command[2]);
                    if (hp >= 0) {
                        int temp = hp + firstData.get(name);
                        if (temp > 100) {
                            temp = 100 - firstData.get(name);
                            firstData.put(name, 100);
                            System.out.printf("%s healed for %d HP!\n", name, temp);
                        } else {
                            firstData.put(name, temp);
                            System.out.printf("%s healed for %d HP!\n", name, hp);
                        }
                    }
                    break;
            }

            input = scan.nextLine();
        }

        firstData.entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(f -> {
                    System.out.println(f.getKey());
                    System.out.printf("HP: %d\n", f.getValue());
                    System.out.printf("MP: %d\n", secondData.get(f.getKey()));
                });
    }
}

