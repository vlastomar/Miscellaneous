import java.util.Scanner;

public class PaswwordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"Done".equals(input)){
            String[] command = input.split("\\s+");
            String token = command[0];
            switch (token){
                case "TakeOdd":
                    String newRawPassword = "";
                    for (int i = 1; i < text.length() ; i+=2) {
                        newRawPassword += text.charAt(i);
                    }

                    text = new StringBuilder(newRawPassword);
                    System.out.println(text);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    int ll = text.length();
                    if (index >= 0 && index < text.length() &&
                    index + length <= text.length()){
                        text = text.delete(index, index + length);
                        System.out.println(text);
                    }
                    break;
                case "Substitute":
                    String old = command[1];
                    String newString = command[2];
                    if (text.toString().contains(old)){
                        text = new StringBuilder(text.toString().replaceAll(old, newString)) ;
                        System.out.println(text);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("Your password is: %s", text);
    }
}

