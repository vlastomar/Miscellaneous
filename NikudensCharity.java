import java.util.Scanner;

public class NikudensCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder word = new StringBuilder(input);

        input = scan.nextLine();
        if (!word.toString().isEmpty()) {
            while (!"Finish".equals(input)) {
                String[] token = input.split("\\s+");
                String command = token[0];
                switch (command) {
                    case "Replace":
                        char oldChar = token[1].charAt(0);
                        char newChar = token[2].charAt(0);
                        String temp = word.toString().replace(oldChar, newChar);
                        word = new StringBuilder(temp);
                        System.out.println(word);
                        break;
                    case "Cut":
                        int startIndex = Integer.parseInt(token[1]);
                        int endIndex = Integer.parseInt(token[2]) + 1;
                        if (startIndex >= 0 && endIndex >= 0 && startIndex < word.length() && endIndex < word.length()) {
                            word = word.delete(startIndex, endIndex);
                            System.out.println(word);
                        } else {
                            System.out.println("Invalid indexes!");
                        }

                        break;
                    case "Make":
                        switch (token[1]) {
                            case "Upper":
                                temp = word.toString().toUpperCase();
                                word = new StringBuilder(temp);
                                break;
                            case "Lower":
                                temp = word.toString().toLowerCase();
                                word = new StringBuilder(temp);
                                break;
                        }
                        System.out.println(word);
                        break;
                    case "Check":
                        String substring = token[1];
                        temp = word.toString();
                        if (temp.contains(substring)) {
                            System.out.println(String.format("Message contains %s", substring));
                        } else {
                            System.out.println(String.format("Message doesn't contain %s", substring));
                        }
                        break;
                    case "Sum":
                        startIndex = Integer.parseInt(token[1]);
                        endIndex = Integer.parseInt(token[2]);
                        if (startIndex >= 0 && endIndex >= 0 && startIndex < word.length() && endIndex + 1 < word.length()) {
                            substring = word.substring(startIndex, endIndex + 1);
                            int sum = 0;
                            for (int i = 0; i < substring.length(); i++) {
                                sum += substring.charAt(i);
                            }
                            System.out.println(sum);
                        } else {
                            System.out.println("Invalid indexes!");
                        }
                        break;
                }

                input = scan.nextLine();
            }
        }
    }
}
