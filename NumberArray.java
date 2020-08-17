import java.util.Arrays;
import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Switch":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.length){
                        numbers[index] = ~(numbers[index] -1);
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.length){
                        numbers[index] = value;
                    }
                    break;
                case "Sum":
                    int count = 0;
                    for(int numb : numbers){
                        if (tokens[1].equals("Negative") && numb < 0){
                           count += numb;
                        }else if ("Positive".equals(tokens[1]) && numb >= 0){
                            count += numb;
                        }else if ("All".equals(tokens[1])){
                            count += numb;
                        }
                    }
                    System.out.println(count);

                    break;

            }

            input = scan.nextLine();
        }
        for (int numb : numbers){
            if (numb >= 0){
                System.out.print(numb + " ");
            }
        }
    }

}
