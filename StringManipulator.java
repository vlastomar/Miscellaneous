import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder word = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"Done".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "Change":
                    String oldChar = token[1];
                    String newChar = token[2];
                    if (word.toString().contains(oldChar)){
                        String temp = word.toString().replaceAll(oldChar, newChar);
                        word = new StringBuilder(temp);
                        System.out.println(word);
                    }

                    break;
                case "Includes":
                    oldChar = token[1];
                    if (word.toString().contains(oldChar)){
                        System.out.println("True");
                    }else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    oldChar = token[1];
                    if (word.toString().contains(oldChar)){
                        int indexStart = word.length() - oldChar.length();
                        newChar = word.substring(indexStart, word.length());
                        if (newChar.equals(oldChar)){
                            System.out.println("True");
                        }else {
                            System.out.println("False");
                        }

                    }

                    break;
                case "Uppercase":
                    oldChar = word.toString().toUpperCase();
                    word = new StringBuilder(oldChar);
                    System.out.println(word);
                    break;
                case "FindIndex":
                    oldChar = token[1];
                    if (word.toString().contains(oldChar)){
                        System.out.println(word.indexOf(oldChar));
                    }

                    break;
                case "Cut":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]) + index1;
                    if (index1 < index2 -1 && index1 >= 0 && index2 - 1 < word.length()){
                        newChar = word.substring(index1, index2);
                        word = new StringBuilder(newChar);
                        System.out.println(word);
                    }
                    break;
            }

            input = scan.nextLine();
        }
    }
}
