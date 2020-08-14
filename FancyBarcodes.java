import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String input = scan.nextLine();
            Pattern patt = Pattern.compile("@[#]+(?<pass>[A-Z][A-Z|a-z|0-9]{4,}[A-Z])@[#]+");
            Matcher mat = patt.matcher(input);

            if (!mat.find()){
                System.out.println("Invalid barcode");
            } else{
                patt = Pattern.compile("@[#]+(?<pass>[A-Z][A-Z|a-z|0-9]{4,}[A-Z])@[#]+");
                mat = patt.matcher(input);
                while (mat.find()){
                    String codeStr = mat.group("pass");
                    Pattern patt1 = Pattern.compile("(?<numb>[0-9])");
                    Matcher mat1 = patt1.matcher(codeStr);
                    String matFindCode = "";
                    if (!mat1.find()){
                        System.out.println("Product group: 00");
                    }else{
                        patt1 = Pattern.compile("(?<numb>[0-9])");
                        mat1 = patt1.matcher(codeStr);
                        while (mat1.find()){
                            String temp = mat1.group("numb");
                            matFindCode += temp;
                        }
                        System.out.printf("Product group: %s\n", matFindCode);
                    }
                }
            }
        }
    }
}
