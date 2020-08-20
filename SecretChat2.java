import java.util.Scanner;

public class SecretChat2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder mainWords = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();

        while (!"Reveal".equals(input)){
            String[] command = input.split(":\\|:");
            String token = command[0];
            switch (token){
                case "InsertSpace":

                    int index = Integer.parseInt(command[1]);
                    if (index >= 1 && index <= mainWords.length()){
                        mainWords.insert(index, ' ');
                    }
                    System.out.println(mainWords);
                    break;
                case "Reverse":
                    String substring = command[1];

                    if (mainWords.toString().contains(substring)){
                        int index1 = mainWords.indexOf(substring);
                        int index2 = index1 + substring.length();
                        mainWords.delete(index1, index2);
                        StringBuilder temp = new StringBuilder(substring);
                        temp = temp.reverse();
                        mainWords.append(temp);
                        System.out.println(mainWords);
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    substring = command[1];
                    String replacement = command[2];
                    if (mainWords.toString().contains(substring)){
                        for (int i = 0; i < mainWords.length() ; i++) {
                           if (mainWords.toString().contains(substring)){
                               int index1 = mainWords.indexOf(substring);
                               int index2 =index1 + substring.length();
                               mainWords.replace(index1, index2, replacement);
                           }
                        }

                    }
                    System.out.println(mainWords);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s", mainWords);


    }
}
