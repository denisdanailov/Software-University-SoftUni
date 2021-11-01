package workingWithAbstraction.exercises.jediGalaxy;

public class Galaxy {
    private int[][] galaxy;

    public Galaxy(int x, int y) {
        this.galaxy = createMatrix(x, y, 0);
    }

    public int getElement(int row, int col) {
        return galaxy[row][col];
    }

    public int[] getRow(int row) {
        return galaxy[row];
    }

    public void put(int row, int col, int element) {
        galaxy[row][col] = element;
    }

    public int length() {
        return this.galaxy.length;
    }

    private static int[][] createMatrix(int row, int col, int startValue) {
        int[][] matrix = new int[row][col];
        int value = startValue;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
