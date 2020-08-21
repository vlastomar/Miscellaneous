import java.util.Scanner;

public class StringManipulator1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "Translate":
                    String oldChar = token[1];
                    String newChar = token[2];
                    if (word.toString().contains(oldChar)){
                        String temp = word.toString();
                        temp = temp.replaceAll(oldChar, newChar);
                        word = new StringBuilder(temp);
                    }
                    System.out.println(word);
                    break;
                case "Includes":
                    oldChar = token[1];
                    if (word.toString().contains(oldChar)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    oldChar = token[1];
                    int index2 = oldChar.length();
                    if (word.toString().contains(oldChar)){
                        String temp = word.substring(0, index2);
                        if (temp.equals(oldChar)){
                            System.out.println("True");
                        }else {
                            System.out.println("False");
                        }
                    }
                    break;
                case "Lowercase":
                    oldChar = word.toString().toLowerCase();
                    word = new StringBuilder(oldChar);
                    System.out.println(word);
                    break;
                case "FindIndex":
                    System.out.println(word.lastIndexOf(token[1]));
                    break;
                case "Remove":
                    int index1 = Integer.parseInt(token[1]);
                    index2 = index1 + Integer.parseInt(token[2]) ;
                    if (index1 >= 0 && index1 < index2 && index2 < word.length()){
                        word.delete(index1, index2);
                    }
                    System.out.println(word);
                    break;
            }

            input = scan.nextLine();
        }
    }
}
