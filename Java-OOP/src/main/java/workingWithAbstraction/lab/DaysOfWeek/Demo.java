package workingWithAbstraction.lab.DaysOfWeek;

public class Demo {
    public static void main(String[] args) {

        DayOfWeek[] days = DayOfWeek.values();

        for (DayOfWeek day : days) {
            System.out.println(day.getName() + " " + day.getValue());
        }

    }
}
