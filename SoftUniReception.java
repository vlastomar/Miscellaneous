import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int eml1Eff = Integer.parseInt(scan.nextLine());
        int eml2Eff = Integer.parseInt(scan.nextLine());
        int eml3Eff = Integer.parseInt(scan.nextLine());
        int studentsCounts = Integer.parseInt(scan.nextLine());



        int allEff = eml1Eff + eml2Eff + eml3Eff;
        int hrsQuestions = studentsCounts / allEff;
        if (studentsCounts % allEff != 0) {
            hrsQuestions += 1;
        }
        int rest = hrsQuestions / 4;
        hrsQuestions += rest;

        System.out.printf("Time needed: %dh.", hrsQuestions);

    }

}
