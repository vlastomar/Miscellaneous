import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> cityPopulation = new TreeMap<>();
        Map<String, Integer> cityGold = new TreeMap<>();

        String target = scan.nextLine();
        while (!"Sail".equals(target)){
            String[] targets = target.split("\\s*\\|\\|\\s*");
            String city = targets[0];
            int population = Integer.parseInt(targets[1]);
            Pattern patt = Pattern.compile("[0-9]+");
            Matcher mat = patt.matcher(targets[2]);
            String temp = "";
            while (mat.find()){
                temp += mat.group();
            }
            int gold = Integer.parseInt(temp);
            cityPopulation.putIfAbsent(city, 0);
            cityGold.putIfAbsent(city, 0);
            if (cityPopulation.containsKey(city)){
                population = population + cityPopulation.get(city);
                gold = gold + cityGold.get(city);
            }
            cityPopulation.put(city, population);
            cityGold.put(city, gold);
            target = scan.nextLine();
        }
        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] command = input.split("\\s*=>\\s*");
            String token = command[0];
            switch (token){
                case "Plunder":
                    String city = command[1];
                    int population = Integer.parseInt(command[2]);
                    Pattern patt = Pattern.compile("[0-9]+");
                    Matcher mat = patt.matcher(command[3]);
                    String temp = "";
                    while (mat.find()){
                        temp += mat.group();
                    }
                    int gold = Integer.parseInt(temp);
                    if (population > cityPopulation.get(city)){
                        population = cityPopulation.get(city);
                    }
                    if (gold > cityGold.get(city)){
                        gold = cityGold.get(city);
                    }
                    System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", city, gold, population));
                    int remainGold = cityGold.get(city) - gold;
                    int remainPopulation = cityPopulation.get(city) - population;
                    if (remainGold <= 0 || remainPopulation <= 0){
                        System.out.printf("%s has been wiped off the map!\n", city);
                        cityGold.remove(city);
                        cityPopulation.remove(city);
                    }else{
                        cityGold.put(city, remainGold);
                        cityPopulation.put(city, remainPopulation);
                    }
                    break;
                case "Prosper":
                    city = command[1];
                    gold = Integer.parseInt(command[2]);
                    if (gold < 0){
                        System.out.println("Gold added cannot be a negative number!" );
                    }else{
                        remainGold = gold + cityGold.get(city);
                        cityGold.put(city, remainGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, city, remainGold );
                    }
                    break;
            }

            input = scan.nextLine();
        }

        if (cityPopulation.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cityGold.size());
            cityGold.entrySet()
                    .stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    . forEach(f ->{
                        System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg", f.getKey(), cityPopulation.get(f.getKey()), f.getValue() ));
                    });
        }


    }
}
