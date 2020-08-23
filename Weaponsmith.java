import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split("\\|");

        String input = scan.nextLine();
        while (!"Done".equals(input)){
            String[] tokens = input.split("\\s+");
            String token = tokens[1];
            switch (token){
                case "Left":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < words.length &&
                            (index - 1 )>= 0 && (index - 1) < words.length){
                        String temp = words[index];
                        words[index] = words[index - 1];
                        words[index - 1] = temp;
                    }


                    break;
                case "Right":
                    index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < words.length &&
                            (index + 1 )>= 0 && (index + 1) < words.length){
                        String temp = words[index];
                        words[index] = words[index + 1];
                        words[index + 1] = temp;
                    }
                    break;
                case "Even":
                    for (int i = 0; i < words.length ; i += 2) {
                        System.out.print(words[i] + " ");
                    }
                    System.out.println();
                    break;
                case "Odd":
                    for (int i = 1; i < words.length ; i += 2) {
                        System.out.print(words[i] + " ");
                    }
                    System.out.println();
                    break;
            }

         input = scan.nextLine();
        }
        String res = "";
        for(String word : words){
            res += word;
        }
        System.out.printf("You crafted %s!%n", res);

    }
}
