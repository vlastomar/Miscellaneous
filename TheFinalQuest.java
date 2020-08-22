import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> words = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"Stop".equals(input)){
            String[] comm = input.split("\\s+");
            String token = comm[0];
            switch (token){
                case "Delete":
                    int index = Integer.parseInt(comm[1]) + 1;
                    if (index >= 0 && index < words.size()){
                        words.remove(index);
                    }
                    break;
                case "Swap":
                    String word1 = comm[1];
                    String word2 = comm[2];
                    if (words.contains(word1) && words.contains(word2)){
                        //String temp = words.get(words.indexOf(word1));
                        index = words.indexOf(word1);
                        int index1 = words.indexOf(word2);
                        words.set(index, word2);
                        words.set(index1, word1);
                    }
                    break;
                case "Put":
                    word1 = comm[1];
                    index = Integer.parseInt(comm[2]) -1;
                    if (index >= 0 && index < words.size()){
                        words.add(index, word1);
                    }
                    break;
                case "Sort":
                    words.sort((s1,s2) -> s2.compareTo(s1));
                    break;
                case "Replace":
                    word1 = comm[1];
                    word2 = comm[2];
                    if (words.contains(word2)){
                        index = words.indexOf(word2);
                        words.set(index, word1);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        for(String wo: words){
            System.out.print(wo + " ");
        }
    }
}
