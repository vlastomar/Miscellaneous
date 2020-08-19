import java.util.*;

public class OntheWaytoAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       Comparator<String> vlado = (c1, c2) -> c2.compareTo(c1);
        Map<String, List<String>> stores = new TreeMap<>(vlado);

        String input = scan.nextLine();
        while (!"END".equals(input)){
            String[] token = input.split("->");
            String command = token[0];
            switch (command){
                case "Add":
                    String name = token[1];
                    String itemsStr = token[2];
                    String[] items = itemsStr.split(",\\s*");
                    stores.putIfAbsent(name, new ArrayList<>());
                    for (int i = 0; i < items.length ; i++) {
                        stores.get(name).add(items[i]);
                    }
                    break;
                case "Remove":
                    if (stores.containsKey(token[1])){
                        stores.remove(token[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Stores list:");

        /*Map<String, Integer> storLen = new TreeMap<>(vlado);
        for (Map.Entry<String, List<String>> entry : stores.entrySet()) {
            storLen.putIfAbsent(entry.getKey(), 0);
            storLen.put(entry.getKey(), entry.getValue().size());
        }*/

        stores.entrySet().stream()
                .sorted((s1,s2) -> {
                    int first = stores.get(s1.getKey()).size();
                    int second = stores.get(s2.getKey()).size();
                    return Integer.compare(second, first);
                })
                .forEach(p -> {
                    System.out.println(p.getKey());
                    for(String s : stores.get(p.getKey())){
                        System.out.println(String.format("<<%s>>", s));
                    }
                } );

    }
}
