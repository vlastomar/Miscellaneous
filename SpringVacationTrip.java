import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysVacation = Integer.parseInt(scan.nextLine());
        double budgetGroup = Double.parseDouble(scan.nextLine());
        int countPeople = Integer.parseInt(scan.nextLine());
        double fuelKm = Double.parseDouble(scan.nextLine());
        double foodExpensesPerson = Double.parseDouble(scan.nextLine());
        double hotelRoomPriceOneNight = Double.parseDouble(scan.nextLine());

        boolean completeVacation = true;



        double currentValueExpenses = 0;
        double expensesDay = 0;
        double fuelExpens = 0;

        currentValueExpenses += daysVacation * foodExpensesPerson * countPeople;
        if (countPeople > 10){
            currentValueExpenses += daysVacation * countPeople * hotelRoomPriceOneNight * 0.75;
        }else {
            currentValueExpenses += daysVacation * countPeople * hotelRoomPriceOneNight;
        }

        for (int i = 1; i <= daysVacation ; i++) {
            int travelDistance = Integer.parseInt(scan.nextLine());
            //expensesDay = fuelKm * travelDistance + foodExpensesPerson * countPeople +
                   // hotelRoomPriceOneNight * countPeople;
            //fuelExpens = fuelExpens + fuelKm * travelDistance;
            currentValueExpenses += travelDistance * fuelKm;
            currentValueExpenses += expensesDay;
        if (i % 3 == 0 || i % 5 == 0){
            currentValueExpenses = currentValueExpenses + 0.4 * currentValueExpenses;
        }
        if (i % 7 == 0){
            double temp = currentValueExpenses * 1.0/ countPeople;
            currentValueExpenses -= temp;
        }
        if (currentValueExpenses > budgetGroup){
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentValueExpenses - budgetGroup);
            completeVacation = false;
            break;
        }

        }
        if (completeVacation){
            double leftMoney = budgetGroup - currentValueExpenses;
            System.out.printf("You have reached the destination. You have %.2f$ budget left."
                    , budgetGroup - currentValueExpenses);
        }


    }
}
