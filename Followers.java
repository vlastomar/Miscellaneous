import java.awt.event.ItemEvent;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> likes = new TreeMap<>();
        Map<String, Integer> comments = new TreeMap<>();


        String input = scan.nextLine();
        while (!"Log out".equals(input)){
            String[] token = input.split(":\\s+");
            String command = token[0];
            switch (command){
                case "New follower":
                    String temp = token[1];
                    likes.putIfAbsent(temp, 0);
                    comments.putIfAbsent(temp, 0);
                    break;
                case "Like":
                    temp = token[1];
                    int count = Integer.parseInt(token[2]);
                    likes.putIfAbsent(temp, 0);
                    comments.putIfAbsent(temp, 0);
                    likes.put(temp, likes.get(temp) + count);
                    break;
                case "Comment":
                    temp = token[1];
                    likes.putIfAbsent(temp, 0);
                    comments.putIfAbsent(temp, 0);
                    comments.put(temp, comments.get(temp) + 1);
                    break;
                case "Blocked":
                    temp = token[1];
                    if (likes.containsKey(temp)){
                        likes.remove(temp);
                        comments.remove(temp);
                    }else{
                        System.out.println(String.format("%s doesn't exist.", temp));
                    }
                    break;
            }


            input = scan.nextLine();
        }

        System.out.println(String.format("%d followers", likes.size()));
        likes.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(p -> {
                    int sum = p.getValue() + comments.get(p.getKey());
                    System.out.println(String.format("%s: %d", p.getKey(), sum));
                });

    }
}
