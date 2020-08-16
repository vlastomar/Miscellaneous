import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> seqTargets = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true){
            String[] input = scan.nextLine().split(" ");
            if ("End".equals(input[0])){
                for (int i = 0; i <seqTargets.size() ; i++) {
                    System.out.print(seqTargets.get(i));
                    if (i < seqTargets.size()-1){
                        System.out.print("|");
                    }
                }
                break;
            }
            switch (input[0]){
                case "Shoot":
                    if (Integer.parseInt(input[1]) < seqTargets.size() && Integer.parseInt(input[1]) >=0){
                        int temp = seqTargets.get(Integer.parseInt(input[1])) - Integer.parseInt(input[2]);
                        if (temp <= 0){
                            seqTargets.remove(Integer.parseInt(input[1]));
                        }else{
                            seqTargets.set(Integer.parseInt(input[1]), temp);
                        }
                    }
                    break;
                case "Add":
                    if (Integer.parseInt(input[1]) < seqTargets.size() && Integer.parseInt(input[1]) >= 0){
                        seqTargets.add(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (Integer.parseInt(input[1]) < seqTargets.size() && Integer.parseInt(input[1]) >= 0 &&
                            (Integer.parseInt(input[1]) + Integer.parseInt(input[2]) ) < seqTargets.size()
                            && (Integer.parseInt(input[1]) - Integer.parseInt(input[2])) >= 0){
                        int temp = Integer.parseInt(input[2]) * 2 + 1;
                        int temp1 = Integer.parseInt(input[1]) - Integer.parseInt(input[2]);
                        for (int i = 0; i < temp ; i++) {
                            seqTargets.remove(temp1);
                        }

                    }else{
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }
    }
}
