import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> inputNumbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());
        List<Integer> maxNum = new ArrayList<>();
        double average = 0.0;

        for (int i = 0; i < inputNumbers.size() ; i++) {
            average += inputNumbers.get(i);
        }
        average = average / inputNumbers.size();

        for (int i = 0; i <inputNumbers.size() ; i++) {
            if (inputNumbers.get(i) > average){
                double tempD = inputNumbers.get(i);
                int temp = (int)tempD;
                maxNum.add(temp);
            }

        }
        if (!maxNum.isEmpty()) {
            if (maxNum.size() <= 5) {
                maxNum.sort((s1, s2) -> s2.compareTo(s1));

            } else {
                maxNum.sort((s1, s2) -> s2.compareTo(s1));
                int temp = maxNum.size() - 5;
                for (int i = 0; i < temp; i++) {
                    int index = maxNum.size() - 1;
                    maxNum.remove(index);
                }
            }
            for (int numb : maxNum) {
                System.out.print(numb + " ");
            }
        }else{
            System.out.println("No");
        }
    }
}
