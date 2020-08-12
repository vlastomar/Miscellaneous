import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> members = new LinkedHashMap<>();
        Map<String, Integer> times = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"start of concert".equals(input)){
            String[] token = input.split("\\;\\s+");
            String command = token[0];
            switch (command){
                case "Add":
                    String name = token[1];
                    String[] memberNames = token[2].split("\\,\\s+");
                    members.putIfAbsent(name, new ArrayList<>());
                    times.putIfAbsent(name, 0);
                    for (int i = 0; i < memberNames.length ; i++) {
                        if (!members.get(name).contains(memberNames[i])){
                            members.get(name).add(memberNames[i]);
                        }
                    }
                    break;
                case "Play":
                    name = token[1];
                    int play = Integer.parseInt(token[2]);
                    members.putIfAbsent(name, new ArrayList<>());
                    times.putIfAbsent(name, 0);
                    times.put(name, times.get(name) + play);
                    break;
            }

            input = scan.nextLine();
        }
            int totalTime = 0;
        for (Map.Entry<String, Integer> entry : times.entrySet()) {
            totalTime += entry.getValue();
        }

        System.out.println(String.format("Total time: %d", totalTime));

        times.entrySet().stream()
                .sorted((s1, s2) ->{
                    int res = s2.getValue().compareTo(s1.getValue());
                    if (res == 0){
                        res = s1.getKey().compareTo(s2.getKey());
                    }
                    return res;
                })
                .forEach(p -> System.out.println(String.format("%s -> %d", p.getKey(), p.getValue())));

        input = scan.nextLine();
        if (members.containsKey(input)){
            System.out.println(input);
            for(String mem : members.get(input)){
                System.out.println(String.format("=> %s", mem));
            }
        }

    }
}
