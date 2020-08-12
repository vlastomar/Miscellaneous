import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> contacts = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        boolean exit = false;
        while (true){
            String[] tokens = scan.nextLine().split("\\s+");
            String switchT = tokens[0];
            switch (switchT){
                case "Add":
                    String contact = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (!contacts.contains(contact) ){
                        contacts.add(contact);
                    }else if (index >= 0 && index < contacts.size() && contacts.contains(contact)){
                        contacts.add(index, contact);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < contacts.size()){
                        contacts.remove(index);
                    }
                    break;
                case "Export":
                    index = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < contacts.size()){
                        if ((index + count) >= contacts.size()){
                            count = contacts.size() - index;
                        }
                        for (int i = index; i < count + index ; i++) {
                            System.out.print(contacts.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Print":
                    System.out.print("Contacts: ");
                    if ("Normal".equals(tokens[1])){
                        for(String con : contacts){
                            System.out.print(con + " ");
                        }
                    }else  if ("Reversed".equals(tokens[1])){
                        for (int i = 0; i < contacts.size()/2 ; i++) {
                            String temp = contacts.get(contacts.size() - 1 -i);
                            contacts.set(contacts.size() -i - 1, contacts.get(i));
                            contacts.set(i, temp);
                        }
                        for(String con : contacts){
                            System.out.print(con + " ");
                        }
                    }

                        exit = true;
                    break;
            }
            if (exit){
                break;
            }
        }
    }
}
