import java.util.Scanner;

public class TasksPlanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] hoursEchTask = scan.nextLine().split("\\s+");

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String token = tokens[0];
            switch (token){
                case "Complete":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < hoursEchTask.length){
                        hoursEchTask[index] = "0";
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    String newTime = tokens[2];
                    if (index >= 0 && index < hoursEchTask.length){
                        hoursEchTask[index] = newTime;
                    }
                    break;
                case "Drop":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < hoursEchTask.length){
                        hoursEchTask[index] = "-1";
                    }
                    break;
                case "Count":
                    String temp = tokens[1];
                    int countCompl = 0;
                    int countIncompl = 0;
                    int countDrop = 0;
                    for(String tim : hoursEchTask){
                        if (tim.equals("0") && temp.equals("Completed")){
                            countCompl++;
                        }else if (Integer.parseInt(tim) < 0 && temp.equals("Dropped")){
                            countDrop++;
                        }else if (Integer.parseInt(tim) > 0 && temp.equals("Incomplete")){
                            countIncompl++;
                        }
                    }
                    if (temp.equals("Completed")){
                        System.out.println(countCompl);
                    }else if (temp.equals("Dropped")){
                        System.out.println(countDrop);
                    }else if (temp.equals("Incomplete")){
                        System.out.println(countIncompl);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        for (String hour : hoursEchTask){
            if (Integer.parseInt(hour) > 0){
                System.out.print(hour + " ");
            }

        }
    }
}
