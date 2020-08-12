
import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> words = new TreeMap<>();

       String input = scan.nextLine();
        while (!"End".equals(input)){
            if (input.contains(":")){
                String[] tokenWords = input.split("\\s+\\|\\s+");
                for (int i = 0; i < tokenWords.length ; i++) {
                    String[] wordDefinition = tokenWords[i].split("\\s*\\:\\s+");
                    String word = wordDefinition[0];
                    String definition = wordDefinition[1];
                    words.putIfAbsent(word, new ArrayList<>());
                    words.get(word).add(definition);
                }
            }else if ("List".equals(input)){
                for (String s : words.keySet()) {
                    System.out.print(s + " ");

                }
                System.out.println();
                break;
            }else{
                String[] wordOnly = input.split("\\s+\\|\\s+");
                for (int i = 0; i < wordOnly.length ; i++) {
                    String temp = wordOnly[i];
                    if (words.containsKey(temp)){
                        System.out.println(temp);
                    words.get(temp).stream()
                            .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                            .forEach(p -> System.out.println(String.format("-%s", p)));

                    }
                }

            }


            input = scan.nextLine();
        }
    }
}
