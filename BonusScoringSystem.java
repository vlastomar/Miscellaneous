import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countStudents = Integer.parseInt(scan.nextLine());
        int countLectures = Integer.parseInt(scan.nextLine());
        int addBonus = Integer.parseInt(scan.nextLine());
        int finalAtt = 0;
        double maxVal =Double.MIN_VALUE;
        int finalMax = 0;

        for (int i = 0; i < countStudents ; i++) {
            int attendance = Integer.parseInt(scan.nextLine());
            double totalBonus = attendance * 1.0  * (5 + addBonus)/ countLectures ;

            if (totalBonus  > maxVal){
                maxVal = totalBonus;
                finalAtt = attendance;
            }
        }
        maxVal = Math.ceil(maxVal);
        finalMax = (int)maxVal;
        System.out.printf("Max Bonus: %d.%n", finalMax);
        System.out.printf("The student has attended %d lectures.", finalAtt);
    }
}
