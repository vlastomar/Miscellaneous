import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmpl = Integer.parseInt(scan.nextLine());
        int secondEmpl = Integer.parseInt(scan.nextLine());
        int thirdEmpl = Integer.parseInt(scan.nextLine());
        int totalPeople = Integer.parseInt(scan.nextLine());

        firstEmpl = firstEmpl + secondEmpl + thirdEmpl;
        secondEmpl = 0;
        thirdEmpl = 0;

        while (true){

            if (totalPeople - firstEmpl <= 0){
                secondEmpl += 1;
                secondEmpl += thirdEmpl;
                System.out.printf("Time needed: %dh.", secondEmpl);
                break;
            }
            totalPeople -= firstEmpl;
            secondEmpl++;
            if (secondEmpl % 3 == 0){
                thirdEmpl++;
            }

        }


    }
}
