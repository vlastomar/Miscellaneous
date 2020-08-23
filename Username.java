import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder userName = new StringBuilder(scan.nextLine());

        String input = scan.nextLine();
        while (!"Sign up".equals(input)){
            String[] token = input.split("\\s+");
            String command = token[0];
            switch (command){
                case "Case":
                    String option = token[1];
                    switch (option) {
                        case "lower":
                            String temp = userName.toString().toLowerCase();
                            userName = new StringBuilder(temp);
                            break;
                        case "upper":
                            temp = userName.toString().toUpperCase();
                            userName = new StringBuilder(temp);
                            break;
                    }
                System.out.println(userName);
                    break;
                case "Reverse":
                    int index1 = Integer.parseInt(token[1]);
                    int index2 = Integer.parseInt(token[2]);
                    if (index1 >=0 && index1 < userName.length() && index2 >= 0 && index2 < userName.length() && index1 < index2){
                        String temp =  userName.substring(index1,index2+1);
                        StringBuilder tempS = new StringBuilder(temp);
                        System.out.println(tempS.reverse());
                    }
                    break;
                case "Cut":
                    String temp = token[1];
                    if (userName.toString().contains(temp)){
                        temp = userName.toString().replaceAll(temp, "");
                        userName = new StringBuilder(temp);
                        System.out.println(userName);

                    }else{
                        System.out.println(String.format("The word %s doesn't contain %s.", userName, temp));
                    }
                    break;
                case "Replace":
                    temp = token[1];
                    if (userName.toString().contains(temp)){
                        temp = userName.toString().replaceAll(temp, "*");
                        userName = new StringBuilder(temp);
                        System.out.println(userName);

                    }
                    break;
                case "Check":
                    temp = token[1];
                    if (userName.toString().contains(temp)){
                        System.out.println("Valid");
                    }else{
                        System.out.println(String.format("Your username must contain %s.", temp));
                    }

                    break;
            }

            input = scan.nextLine();
        }
    }
}
