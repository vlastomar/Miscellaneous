import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> books = Arrays.stream(scan.nextLine().split("\\&")).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!"Done".equals(command)){
            String[] tokens = command.split(" \\| ");
            String comm = tokens[0];
            String firstToken = tokens[1];

            switch (comm){
                case "Add Book":
                    if (!books.contains(firstToken)){
                        books.add(0,firstToken);
                    }
                    break;
                case "Take Book":
                    if (books.contains(firstToken)){
                        books.remove(firstToken);
                    }
                    break;
                case "Swap Books":
                    String secondToken = tokens[2];

                    if (books.contains(firstToken) && books.contains(secondToken)){
                        int temp = books.indexOf(firstToken);
                        int temp1 = books.indexOf(secondToken);
                        books.set(temp,secondToken);
                        books.set(temp1,firstToken);
                    }
                    break;
                case "Insert Book":
                    books.add(firstToken);
                    break;
                case "Check Book":
                    int checkBook = Integer.parseInt(firstToken);
                    if (checkBook >= 0 && checkBook < books.size()){
                        System.out.println(books.get(checkBook));
                    }
                    break;
            }


        command = scan.nextLine();
        }
        for (int i = 0; i < books.size() ; i++) {
            System.out.print(books.get(i));
            if (i < books.size() - 1){
                System.out.print(", ");
            }
        }

    }
}
