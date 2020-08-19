import java.util.*;

public class PracticeSsessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> roads = new TreeMap<>();

        String input = scan.nextLine();
        while (!"END".equals(input)){
            String[] token = input.split("->");
            String command = token[0];
            switch (command){
                case "Add":
                    roads.putIfAbsent(token[1], new ArrayList<>());
                    roads.get(token[1]).add(token[2]);
                    break;
                case "Move":
                    if (roads.containsKey(token[1]) && roads.containsKey(token[3])){
                        if (roads.get(token[1]).contains(token[2])){
                            roads.get(token[1]).remove(token[2]);
                            roads.get(token[3]).add(token[2]);
                        }
                    }
                    break;
                case "Close":
                    if (roads.containsKey(token[1])){
                        roads.remove(token[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Practice sessions:");
        roads.entrySet().stream()
                .sorted((s1, s2) -> {
                    int first = roads.get(s1.getKey()).size();
                    int second = roads.get(s2.getKey()).size();
                    return Integer.compare(second,first);
                })
                .forEach(p ->{
                    System.out.println(p.getKey());
                    p.getValue().forEach(f -> System.out.println(String.format("++%s", f)));
                });
    }

}
