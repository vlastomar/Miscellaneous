import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Integer> carsFirstData = new TreeMap<>();
        TreeMap<String, Integer> carsSecondData = new TreeMap<>();

        int numberCars = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numberCars ; i++) {
            String[] input = scan.nextLine().split("\\s*\\|\\s*");
            String car = input[0];
            int km = Integer.parseInt(input[1]);
            int fuelAvailabl = Integer.parseInt(input[2]);
            carsFirstData.putIfAbsent(input[0], 0);
            carsFirstData.put(input[0], km);
            carsSecondData.putIfAbsent(input[0], 0);
            carsSecondData.put(input[0], fuelAvailabl);
        }

        String input = scan.nextLine();
        while (!"Stop".equals(input)){
            String[] command = input.split("\\s*\\:\\s*");
            String token = command[0];

            switch (token){
                case "Drive":
                    String car = command[1];
                    int km = Integer.parseInt(command[2]);
                    int requredFuel = Integer.parseInt(command[3]);
                    int availableFuel = carsSecondData.get(car);
                    if (availableFuel < requredFuel){
                        System.out.println("Not enough fuel to make that ride");
                    }else{
                        int totalKm = km + carsFirstData.get(car);
                        carsFirstData.put(car, totalKm);
                        int remainingFuel = carsSecondData.get(car) - requredFuel;
                        carsSecondData.put(car, remainingFuel);
                        System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.", car, km, requredFuel));
                        if (carsFirstData.get(car) >= 100000){
                            carsFirstData.remove(car);
                            carsSecondData.remove(car);
                            System.out.println(String.format("Time to sell the %s!", car));
                        }
                    }
                    break;
                case "Refuel":
                    car = command[1];
                    requredFuel = Integer.parseInt(command[2]);
                    if (carsSecondData.get(car) + requredFuel > 75){
                        int fuelAdd = 75 - carsSecondData.get(car);
                        carsSecondData.put(car, 75);
                        System.out.printf("%s refueled with %d liters\n", car, fuelAdd );
                    }else{
                        int fuel = carsSecondData.get(car) + requredFuel;
                        carsSecondData.put(car, fuel);
                        System.out.printf("%s refueled with %d liters\n", car, requredFuel);
                    }
                    break;
                case "Revert":
                    car = command[1];
                    km = Integer.parseInt(command[2]);
                    if (carsFirstData.get(car) - km < 10000){
                        carsFirstData.put(car, 10000);
                    }else{
                        int newKm = carsFirstData.get(car) - km;
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, km);
                        carsFirstData.put(car, newKm);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        carsFirstData.entrySet()
                .stream()
                .sorted((s1,s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(f ->{
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", f.getKey(), f.getValue(), carsSecondData.get(f.getKey()));
                });
    }
}
