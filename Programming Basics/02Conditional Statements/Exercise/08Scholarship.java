package ConditionalStatements.Exercises;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = Double.parseDouble(scan.nextLine());
        double avgScore = Double.parseDouble(scan.nextLine());
        double minIncome = Double.parseDouble(scan.nextLine());
        //Проверка за социална стипендия
        double socialScholarShip = 0;
        double excellentScholarShip = 0;
        String output ="";

        if (income < minIncome){
            if (avgScore>5.50){
                socialScholarShip = Math.floor(minIncome*0.35);
            }
        }

        if (avgScore >= 5.50){
            excellentScholarShip = Math.floor(avgScore*25);
        }

        //Проверка дали изобщо може да получи стипендия
        if (socialScholarShip==0){
            if (excellentScholarShip==0) {
                output = "You cannot get a scholarship!";
            } }else if (socialScholarShip>excellentScholarShip){
                output=String.format("You get a Social scholarship %.0f BGN",socialScholarShip);
            }else {
                output=String.format("You get a scholarship for excellent results %.0f BGN",excellentScholarShip);
            }
    }
}
