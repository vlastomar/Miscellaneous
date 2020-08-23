import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"For Azeroth".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "GladiatorStance":
                    String temp = word.toString().toUpperCase();
                    word = new StringBuilder(temp);
                    System.out.println(word);
                    break;
                case "DefensiveStance":
                    temp = word.toString().toLowerCase();
                    word = new StringBuilder(temp);
                    System.out.println(word);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(token[1]);
                    temp = token[2];
                    if (index >= 0 && index < word.length()){
                        word.replace(index, index + 1,temp);
                        System.out.println("Success!");
                    }else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    temp = token[1];
                    switch (temp){
                        case "Change":
                            String old = token[2];
                            String newStr = token[3];
                            if (word.toString().contains(old)){
                                String newWord = word.toString().replaceAll(old, newStr);
                                 word = new StringBuilder(newWord);
                                System.out.println(word);
                            }

                            break;
                        case "Remove":
                            old = token[2];
                            if (word.toString().contains(old)){
                                 while (word.toString().contains(old)){
                                     int startIndex = word.indexOf(old);
                                     int endIndex = startIndex + old.length() + 1;
                                     word.delete(startIndex, endIndex);
                                 }

                                System.out.println(word);
                            }

                            break;
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }

            input = scan.nextLine();
        }


    }
}
