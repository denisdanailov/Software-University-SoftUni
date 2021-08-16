package ConditionalStatements.Exercises;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());
        String convertFrom = scan.nextLine();
        String convertTo = scan.nextLine();

        if (convertFrom.equals("mm")){
            num = num/1000;
        }else if (convertFrom.equals("cm")){
            num = num/100;
        }

        if (convertTo.equals("mm")){
            num = num*1000;
        }else if (convertTo.equals("cm")){
            num = num *100;
        }
        System.out.printf("%.3f",num);
    }
}
