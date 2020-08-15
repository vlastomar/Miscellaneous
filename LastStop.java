import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> instructions = Arrays.stream(scan.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Change":
                    int number1 = Integer.parseInt(tokens[1]);
                    int number2 = Integer.parseInt(tokens[2]);
                    if (instructions.contains(number1)){
                        int index = instructions.indexOf(number1);
                        instructions.set(index, number2);
                    }
                    break;
                case "Hide":
                    number1 = Integer.parseInt(tokens[1]);
                    if (instructions.contains(number1)){
                        instructions.remove(Integer.valueOf(number1));
                    }
                    break;
                case "Switch":
                    number1 = Integer.parseInt(tokens[1]);
                    number2 = Integer.parseInt(tokens[2]);
                    if (instructions.contains(number1) && instructions.contains(number2)){
                        int index1 = instructions.indexOf(number1);
                        int index2 = instructions.indexOf(number2);
                        instructions.set(index1, number2);
                        instructions.set(index2, number1);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]) + 1;
                    number1 = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < instructions.size()){
                        instructions.add(index, number1);
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < instructions.size()/2 ; i++) {
                        int temp =  instructions.get(instructions.size() -1 -i);
                        instructions.set(instructions.size() - 1 -i, instructions.get(i));
                        instructions.set(i, temp);
                    }
                    break;
            }

            input = scan.nextLine();
        }

        for(int numb : instructions){
            System.out.print(numb + " ");
        }
    }
}
