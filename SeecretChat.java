import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        List<String> messageL = Arrays.stream(message.split("")).collect(Collectors.toList());

        while (true){
            String input = scan.nextLine();
            if ("Reveal".equals(input)){
                System.out.print("You have a new text message: ");
                printList(messageL);
                break;
            }
            List<String> operation = Arrays.stream(input.split(":\\|:")).collect(Collectors.toList());
            switch (operation.get(0)){
                case "InsertSpace":
                    messageL.add(Integer.parseInt(operation.get(1)), " ");
                    printList(messageL);
                    break;
                case "Reverse":
                    String coincidence = "";
                    int lastPosSearsc = 0;
                    boolean check = false;
                    for (int i = 0; i < messageL.size() ; i++) {
                        String temp = messageL.get(i);
                        for (int j = i+1; j < messageL.size() ; j++) {
                            temp += messageL.get(j);
                            if (temp.equals(operation.get(1))){
                                coincidence = temp;
                                lastPosSearsc = j;
                                check = true;
                                break;
                            }
                        }
                         if (check)        {
                             break;
                         }
                         temp = "";
                    }
                    if (coincidence.equals("")){
                        System.out.println("error");
                        break;
                    }
                    for (int i = lastPosSearsc - coincidence.length() + 1; i < lastPosSearsc ; i++) {
                        messageL.remove(i);
                        i = lastPosSearsc - coincidence.length();
                        if (messageL.size() == lastPosSearsc - coincidence.length() +1){
                            break;
                        }
                    }
                    List<String> listReverse = Arrays.stream(coincidence.split("")).collect(Collectors.toList());
                    for (int i = 0; i < listReverse.size()/2 ; i++) {
                        String temp = listReverse.get(i);
                        listReverse.set(i, listReverse.get(listReverse.size()-i -1));
                        listReverse.set(listReverse.size()-i -1, temp);
                    }
                    for (int i = 0; i < listReverse.size() ; i++) {
                        messageL.add(listReverse.get(i));
                    }
                    printList(messageL);
                    break;
                case "ChangeAll":
                    for (int i = 0; i < messageL.size() ; i++) {
                        if (messageL.get(i).equals(operation.get(1))){
                            messageL.set(i, operation.get(2));
                        }
                    }
                    printList(messageL);
                    break;
            }
        }

    }
    public static void printList(List<String> printL){
        for(String world : printL){
            System.out.print(world);
        }
        System.out.println();
    }
}
