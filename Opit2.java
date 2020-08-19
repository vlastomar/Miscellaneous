import java.util.Scanner;

public class Opit2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int empl1 = Integer.parseInt(scan.nextLine());
        int empl2 = Integer.parseInt(scan.nextLine());
        int empl3 = Integer.parseInt(scan.nextLine());
        int studentsQuestions = Integer.parseInt(scan.nextLine());

        int total = empl1 + empl2 + empl3;
        int hrs = 0;
        int count = 0;

        while (studentsQuestions > 0){
            count++;
            if (count % 4 == 0){
                hrs++;
            }else{
                studentsQuestions -= total;

                hrs++;
            }

        }

        System.out.printf("Time needed: %dh.", hrs);
    }
}
