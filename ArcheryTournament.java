import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String targets = scan.nextLine();
        int[] targetsArr = Arrays.stream(targets.split("\\|")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int pointsIskren = 0;
        String command = scan.nextLine();

        while (!"Game over".equals(command)) {
            String[] token = command.split("\\@");

            String tokens = token[0];


            switch (tokens) {
                case "Shoot Left":
                    int startPos = Integer.parseInt(token[1]);
                    int steps = Integer.parseInt(token[2]);
                    if (startPos >= 0 && startPos < targetsArr.length) {
                        startPos -= steps;

                            while (startPos < 0){
                                startPos = targetsArr.length + startPos;
                            }



                        if (targetsArr[startPos] >= 5) {
                            targetsArr[startPos] -= 5;
                            pointsIskren += 5;
                        } else {
                            pointsIskren += targetsArr[startPos];
                            targetsArr[startPos] = 0;
                        }

                    }
                    break;
                case "Shoot Right":
                    startPos = Integer.parseInt(token[1]);
                    steps = Integer.parseInt(token[2]);
                    if (startPos >= 0 && startPos < targetsArr.length) {
                        startPos += steps;
                        if (startPos >= targetsArr.length && steps < targetsArr.length) {
                            startPos = steps - 1;
                        }else if (startPos >= targetsArr.length && steps >= targetsArr.length){
                            while (steps > targetsArr.length){
                                steps = steps - targetsArr.length;
                            }
                            startPos = steps - 1;
                        }
                        if (targetsArr[startPos] >= 5) {
                            targetsArr[startPos] -= 5;
                            pointsIskren += 5;
                        } else {
                            pointsIskren += targetsArr[startPos];
                            targetsArr[startPos] = 0;
                        }



                    }
                    break;
                case    "Reverse":
                    for (int i = 0; i < targetsArr.length/2 ; i++) {
                        int temp = targetsArr[i];
                        targetsArr[i] = targetsArr[targetsArr.length - 1 - i];
                        targetsArr[targetsArr.length - 1 - i] = temp;

                    }
                    break;



            }
            command = scan.nextLine();
        }
        for (int i = 0; i < targetsArr.length ; i++) {
            System.out.print(targetsArr[i]);
            if (i < targetsArr.length - 1){
                System.out.print(" - ");
            }
        }
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!",pointsIskren );
    }
}
