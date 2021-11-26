package workingWithAbstraction.exercises.jediGalaxy;

public class Evil {

    private final int[] coordinates;

    public Evil(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public Galaxy destroyStars(Galaxy galaxy) {
        int evilX = this.coordinates[0];
        int evilY = this.coordinates[1];

        while (evilX >= 0 && evilY >= 0) {
            if (evilX < galaxy.length() && evilY < galaxy.getRow(0).length) {
                galaxy.put(evilX, evilY, 0);
            }
            evilX--;
            evilY--;
        }

        return galaxy;
    }
}
