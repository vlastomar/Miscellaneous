package Fire;

import java.util.Scanner;

public class SeizetheFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] fireCells = scan.nextLine().split("#");
        int water = Integer.parseInt(scan.nextLine());
        double effort = 0.0;
        int totalWaterForFire = 0;
        Calc vlado = new Calc(effort,totalWaterForFire, water);
        System.out.println("Cells:");
        for (int i = 0; i < fireCells.length ; i++) {
            String tokens[] = fireCells[i].split(" = ");
            String typeFire = tokens[0];
            int waterPerFire = Integer.parseInt(tokens[1]);
            switch (typeFire){
                case "High":

                    if (waterPerFire >= 81 && waterPerFire <= 125){
                        calculations(vlado, waterPerFire );
                    }


                    break;
                case "Medium":
                    if (waterPerFire >= 51 && waterPerFire <= 80){
                         calculations(vlado, waterPerFire);
                    }
                    break;
                case "Low":
                    if (waterPerFire >= 1 && waterPerFire <= 50){
                        calculations(vlado, waterPerFire);
                    }
                    break;
            }

        }

        System.out.printf("Effort: %.2f%n", vlado.getEffort());
        System.out.printf("Total Fire: %d", vlado.getTotalWater());

    }
    public static Calc calculations(Calc vlado, int waterPerFire){
        if (vlado.getWater() >= waterPerFire){
            vlado.setWater(vlado.getWater() - waterPerFire);
            double temp = vlado.getEffort() + waterPerFire * 0.25;
            vlado.setEffort(temp);
            vlado.setTotalWater(vlado.getTotalWater() + waterPerFire);
            System.out.println(" - " + waterPerFire);
        }

        return vlado;

    }

}

