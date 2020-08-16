import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> send = new TreeMap<>();
        Map<String, Integer> receive = new TreeMap<>();

        int capacity = Integer.parseInt(scan.nextLine());
        String token = scan.nextLine();
        while (!"Statistics".equals(token)){
            String[] input = token.split("\\=");
            String command = input[0];
            switch (command){
                case "Add":
                    String name = input[1];
                    int sent = Integer.parseInt(input[2]);
                    int received = Integer.parseInt(input[3]);
                    send.putIfAbsent(name, sent);
                    receive.putIfAbsent(name, received);

                    break;
                case "Message":
                    String sender = input[1];
                    String receiver = input[2];
                    if (send.containsKey(sender) && receive.containsKey(receiver)){
                        send.put(sender, send.get(sender) + 1);
                        receive.put(receiver, receive.get(receiver) + 1);
                        if (send.get(sender) + receive.get(sender) >= capacity){
                            send.remove(sender);
                            receive.remove(sender);
                            System.out.println(String.format("%s reached the capacity!", sender));
                        }

                        if (receive.get(receiver) + send.get(receiver) >= capacity){
                            receive.remove(receiver);
                            send.remove(receiver);
                            System.out.println(String.format("%s reached the capacity!", receiver));
                        }
                    }

                    break;
                case "Empty":
                    String delete = input[1];
                    if ("All".equals(delete)){
                        send = new TreeMap<>();
                        receive = new TreeMap<>();
                    } else {
                        if (send.containsKey(delete)){
                            send.remove(delete);
                            receive.remove(delete);
                        }
                    }
                    break;
            }

            token = scan.nextLine();
        }

        System.out.println(String.format("Users count: %d", send.size()));

        Map<String, Integer> finalSend = send;
        receive.entrySet().stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(p ->{
                    int result = p.getValue() + finalSend.get(p.getKey());
                    System.out.println(String.format("%s - %d", p.getKey(), result));
                });




    }
}
