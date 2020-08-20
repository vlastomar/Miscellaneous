import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RadoDateFiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        List<LocalDate> dates = new ArrayList<>();
         dates.add(LocalDate.parse("2020-06-15"));
        dates.add(LocalDate.parse("2020-05-06"));
        dates.add(LocalDate.parse("2014-05-10"));
        dates.add(LocalDate.parse("2013-05-01"));

        for (int i = 0; i <dates.size() ; i++) {
            System.out.print(dates.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i <dates.size() ; i++) {
            //dates.add(LocalDate.now().minusMonths(3));
            if (dates.get(i).isBefore(LocalDate.now().minusMonths(3))){

          dates.remove(i)     ;
          i = -1;
            }
        }


        for (int i = 0; i <dates.size() ; i++) {
            System.out.print(dates.get(i) + " ");
        }


    }

}
