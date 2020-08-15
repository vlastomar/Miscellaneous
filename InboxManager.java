import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> usernameEmail = new TreeMap<>();

        String input = scan.nextLine();
        while (!"Statistics".equals(input)){
            String[] token = input.split("->");
            switch (token[0]){
                case "Add":
                    if (!usernameEmail.containsKey(token[1])){
                        usernameEmail.putIfAbsent(token[1], new ArrayList<>());
                    }else {
                        System.out.println(String.format("%s is already registered", token[1]));
                    }
                    break;
                case "Send":
                    String username = token[1];
                    String email = token[2];
                    if (usernameEmail.containsKey(username)){
                        usernameEmail.get(username).add(email);
                    }
                    break;
                case "Delete":
                    username = token[1];
                    if (usernameEmail.containsKey(username)){
                        usernameEmail.remove(username);
                    }else {
                        System.out.println(String.format("%s not found!", username));
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(String.format("Users count: %d", usernameEmail.size()));
        usernameEmail.entrySet().stream()
                .sorted(((s1,s2) ->{
                    int first = s1.getValue().size();
                    int second = s2.getValue().size();
                    return Integer.compare(second, first);
                }))
                .forEach(p -> {
                    System.out.println(p.getKey());
                    for (int i = 0; i <p.getValue().size() ; i++) {
                        System.out.println(String.format("- %s", p.getValue().get(i)));
                    }

                });
    }
}
