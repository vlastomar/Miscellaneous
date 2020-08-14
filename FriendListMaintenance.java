import java.util.Scanner;

public class FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String names = scan.nextLine();
        String[] userNames = names.split(", ");

        String input = scan.nextLine();
        int blacklisted = 0;
        int lostName = 0;

        while (!"Report".equals(input)){
            String[] tokens = input.split(" ");
            String token = tokens[0];

            switch (token){
                case "Blacklist":
                    String nameToken = tokens[1];
                    Boolean check = true;
                    for (int i = 0; i < userNames.length ; i++) {
                        if (userNames[i].equals(nameToken)){
                            userNames[i] = "Blacklisted";
                            blacklisted++;
                            check = false;
                            System.out.printf("%s was blacklisted.%n", nameToken);
                        }

                    }
                    if (check){
                    System.out.printf("%s was not found.%n", nameToken);
                    }
                    break;
                case "Error":
                    int tokenIndex = Integer.parseInt(tokens[1]);
                    if (!userNames[tokenIndex].equals("Blacklisted") &&  !userNames[tokenIndex].equals("Lost")){
                        String tempName = userNames[tokenIndex];
                        userNames[tokenIndex] = "Lost";
                        lostName++;
                        System.out.printf("%s was lost due to an error.%n", tempName);
                    }
                    break;
                case "Change":
                    tokenIndex = Integer.parseInt(tokens[1]);
                    String tempName = tokens[2];
                    if (tokenIndex >= 0 && tokenIndex < userNames.length){
                        System.out.printf("%s changed his username to %s.%n", userNames[tokenIndex], tempName);
                        userNames[tokenIndex] = tempName;
                    }
                    break;
            }

          input = scan.nextLine();
        }
        System.out.println("Blacklisted names: " + blacklisted);
        System.out.println("Lost names: " + lostName);
        for (int i = 0; i <userNames.length ; i++) {
            System.out.print(userNames[i]);
            if (i < userNames.length - 1){
                System.out.print(" ");
            }
        }
    }
}
