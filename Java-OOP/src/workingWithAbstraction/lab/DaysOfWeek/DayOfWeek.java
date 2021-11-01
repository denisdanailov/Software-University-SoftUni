package workingWithAbstraction.lab.DaysOfWeek;

public enum DayOfWeek {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    Thursday("Thursday", 4),
    Friday("Friday", 5),
    Saturday("Saturday", 6),
    SUNDAY("Sunday", 7);

    private String name;
    private int value;

    private DayOfWeek(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
