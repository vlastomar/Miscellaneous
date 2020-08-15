import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> heroes = new TreeMap<>();

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "Enroll":
                    if (heroes.containsKey(token[1])){
                        System.out.println(String.format("%s is already enrolled.", token[1]));

                    }else{
                        heroes.putIfAbsent(token[1], new ArrayList<>());
                    }
                    break;
                case "Learn":
                    if (heroes.containsKey(token[1])){
                        if (heroes.get(token[1]).contains(token[2])){
                            System.out.println(String.format("%s has already learnt %s.", token[1], token[2]));
                        }else{
                            heroes.get(token[1]).add(token[2]);
                        }
                    }else{
                        System.out.println(String.format("%s doesn't exist.", token[1]));
                    }

                break;
                case "Unlearn":
                    if (heroes.containsKey(token[1])){
                        if (heroes.get(token[1]).contains(token[2])){
                            heroes.get(token[1]).remove(token[2]);
                        }else{
                            System.out.println(String.format("%s doesn't know %s.", token[1], token[2]));
                        }

                    }else{
                        System.out.println(String.format("%s doesn't exist.", token[1]));
                    }

                break;
            }

            input = scan.nextLine();
        }
        System.out.println("Heroes:");
        heroes.entrySet().stream()
                .sorted((s1,s2) ->{
                    int first = s1.getValue().size();
                    int second = s2.getValue().size();
                    return Integer.compare(second,first);
                })

                .forEach(p -> {
                    System.out.print(String.format("== %s: ", p.getKey()));
                    for (int i = 0; i < p.getValue().size() ; i++) {
                        if (i < p.getValue().size() - 1){
                            System.out.print(String.format("%s, ", p.getValue().get(i)));
                        } else{
                            System.out.print(p.getValue().get(i));
                        }
                    }
                    System.out.println();
                });
    }
}
