import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"Travel".equals(input)){
            String[] token = input.split(":");
            switch (token[0]){
                case "Add Stop":
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < stops.length()){
                       stops.insert(index, token[2]);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    index = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    if (index >= 0 && endIndex < stops.length() && index < stops.length() && endIndex >= 0){
                        stops.delete(index, endIndex + 1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    if (stops.toString().contains(token[1])){

                        stops = new StringBuilder(stops.toString().replaceAll(token[1], token[2]));
                    }
                    System.out.println(stops);
                    break;
            }


           input = scan.nextLine();
        }
        System.out.println(String.format("Ready for world tour! Planned stops: %s", stops));
    }
}
