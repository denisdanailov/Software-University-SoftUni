package workingWithAbstraction.lab.HotelReservation;

public enum Season {
    AUTUMN("Autumn",1),
    SPRING("Spring",2),
    WINTER("Winter",3),
    SUMMER("Summer",4);

    private String name;
    private int multiplicator;

    private Season(String name, int value) {
        this.name = name;
        this.multiplicator = value;
    }

    public int getMultiplicator() {
        return multiplicator;
    }

    public String getName() {
        return name;
    }
}
