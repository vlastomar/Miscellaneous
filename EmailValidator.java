import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder email = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"Complete".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "Make":
                    String option = token[1];
                    switch (option){
                        case "Upper":
                            String temp = email.toString().toUpperCase();
                            email = new StringBuilder(temp);
                            System.out.println(email);
                            break;
                        case "Lower":
                            temp = email.toString().toLowerCase();
                            email = new StringBuilder(temp);
                            System.out.println(email);
                            break;
                    }
                    break;
                case "GetDomain":
                    int number = Integer.parseInt(token[1]);
                    String forPrint =  email.substring(email.length() - number, email.length());
                    System.out.println(forPrint);
                    break;
                case "GetUsername":
                    if (email.toString().contains("@")){
                        int endIndex = email.indexOf("@");
                        forPrint = email.substring(0, endIndex);
                        System.out.println(forPrint);
                    }else {
                        System.out.println(String.format("The email %s doesn't contain the @ symbol.", email));
                    }
                    break;
                case "Replace":
                    String forReplace = token[1];
                    String temp  =  email.toString().replaceAll(forReplace, "-");
                    email = new StringBuilder(temp);
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length() ; i++) {
                        int letter = (int)email.charAt(i);
                        System.out.print(letter + " ");                    }
                    break;
            }


            input = scan.nextLine();
        }
    }
}
