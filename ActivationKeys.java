import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String initial = scan.nextLine();
        Pattern patt = Pattern.compile("[A-Za-z0-9]");
        String initialCorrected = "";
        Matcher mat = patt.matcher(initial);
        while (mat.find()){
            initialCorrected += mat.group();
        }
        StringBuilder activationKey = new StringBuilder(initialCorrected);

        String input = scan.nextLine();
        while (!"Generate".equals(input)){
            String[] command = input.split(">>>");
            String token = command[0];
            switch (token){
                case "Contains":
                    String substring = command[1];
                    if (activationKey.toString().contains(substring)){
                        System.out.println(String.format("%s contains %s", activationKey, substring));
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String caseLetter = command[1];
                    int startIndex = Integer.parseInt(command[2]);
                    int endIndex = Integer.parseInt(command[3]);
                    if (endIndex >= 0 && endIndex - 1 < activationKey.length()
                        && startIndex >= 0 && startIndex < activationKey.length()){
                        switch (caseLetter){
                            case "Lower":
                                String lowerCase = activationKey.substring(startIndex, endIndex).toLowerCase();
                                activationKey.replace(startIndex, endIndex, lowerCase);
                                break;
                            case "Upper":

                                String upperCase = activationKey.substring(startIndex, endIndex).toUpperCase();
                                activationKey.replace(startIndex, endIndex, upperCase);
                                break;
                        }

                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(command[1]);
                    endIndex = Integer.parseInt(command[2]) ;
                    if (endIndex >= 0 && endIndex - 1 < activationKey.length()
                            && startIndex >= 0 && startIndex < activationKey.length()){
                         activationKey.delete(startIndex, endIndex);
                    }
                    System.out.println(activationKey);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(String.format("Your activation key is: %s", activationKey));
    }
}

