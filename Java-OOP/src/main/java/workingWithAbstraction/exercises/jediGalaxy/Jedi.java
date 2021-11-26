package workingWithAbstraction.exercises.jediGalaxy;

public class Jedi {
    private final int[] coordinates;
    private int starsCollected;

    public Jedi(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void collectStars(Galaxy galaxy) {
        int jediX = this.coordinates[0];
        int jediY = this.coordinates[1];

        while (jediX >= 0 && jediY < galaxy.getRow(0).length) {
            if (jediX < galaxy.length() && jediY >= 0) {
                this.starsCollected += galaxy.getElement(jediX, jediY);
            }
            jediY++;
            jediX--;
        }
    }

    public int getStarsCollected() {
        return this.starsCollected;
    }
}
