import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PlanDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        Map<String, Integer> rarities = new HashMap<>();
        Map<String, List<Integer>>  rates = new HashMap<>();

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("<->");
            rarities.putIfAbsent(input[0], 0);
            rates.putIfAbsent(input[0], new ArrayList<>());
            rarities.put(input[0], Integer.parseInt(input[1]));
        }

        String input = scan.nextLine();
        while (!"Exhibition".equals(input)){
            String[] token = input.split(": ");
            switch (token[0]){
                case "Rate":

                    String[] option = token[1].split("\\s+\\-\\s+");
                    if (rates.containsKey(option[0])){
                        rarities.putIfAbsent(option[0], 0);
                        rates.putIfAbsent(option[0], new ArrayList<>());
                        rates.get(option[0]).add(Integer.parseInt(option[1]));
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "Update":
                    option = token[1].split("\\s+\\-\\s+");
                    if (rarities.containsKey(option[0])){
                        rarities.put(option[0], Integer.parseInt(option[1]));
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    option = token[1].split("\\s+\\-\\s+");
                    if (rates.containsKey(option[0])){
                        rates.put(option[0], new ArrayList<>());
                    }else{
                        System.out.println("error");
                    }
                    break;
            }

            input = scan.nextLine();
        }
        Map<String, TreeMap<Integer,Double>> average = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : rates.entrySet()) {
            int sum = 0;
            Double aver = 0.00;
            if (!entry.getValue().isEmpty()){
                for(int s : entry.getValue() ){
                    sum += s;
                }
                aver = sum * 1.00 / entry.getValue().size();
            }

            Comparator<Integer> vlado = (c1,c2) -> Integer.compare(c2,c1);

            average.putIfAbsent(entry.getKey(), new TreeMap<>(vlado));
            average.get(entry.getKey()).putIfAbsent(rarities.get(entry.getKey()), 0.0);
            average.get(entry.getKey()).put(rarities.get(entry.getKey()), aver);
        }
        System.out.println("Plants for the exhibition:");
        average.entrySet().stream()
                . sorted((s1, s2) -> {
                    int[] first = {0};
                    int[] second = {0};
                    average.get(s1.getKey()).entrySet().stream()
                            .forEach(f -> {
                                first[0] = f.getKey();
                            });
                    average.get(s2.getKey()).entrySet().stream()
                            .forEach(f -> {
                                second[0] = f.getKey();
                            });
                    int res = Integer.compare(second[0], first[0]);
                    if (res == 0){
                        Double one = s2.getValue().get(rarities.get(s2.getKey()));
                        Double two = s1.getValue().get(rarities.get(s1.getKey()));
                        final int compare = Double.compare(one, two);
                        return compare;
                    }else{
                        return res;
                    }

                })
                . forEach(p ->{
                    System.out.println(String.format("- %s; Rarity: %d; Rating: %.2f", p.getKey(), rarities.get(p.getKey()), p.getValue().get(rarities.get(p.getKey()))));
                });
     }
}
