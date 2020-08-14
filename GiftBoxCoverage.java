import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sizeSide = Double.parseDouble(scan.nextLine());
        int sheetsPaper = Integer.parseInt(scan.nextLine());
        double singleSheetCoverArea = Double.parseDouble(scan.nextLine());

        double area = sizeSide * sizeSide * 6.0;
        double sum = 0.0;
        for (int i = 1; i <=sheetsPaper ; i++) {
            if (i % 3 == 0){
                sum += singleSheetCoverArea * 0.25;
            }else {
                sum += singleSheetCoverArea;
            }
        }

        double pct = sum * 100.0 / area;
        System.out.printf("You can cover %.2f%% of the box.", pct);
    }
}
