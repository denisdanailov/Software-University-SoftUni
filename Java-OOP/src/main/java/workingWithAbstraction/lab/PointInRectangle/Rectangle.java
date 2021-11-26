package workingWithAbstraction.lab.PointInRectangle;

public class Rectangle {
    Point A;
    Point B;

    public Rectangle (int[] arr) {
        this.A = new Point(arr[0], arr[1]);
        this.B = new Point(arr[2], arr[3]);
    }

    public boolean contains(Point point) {
        // Bottom border
        if (point.getX() >= A.getX() && point.getY() >= A.getY()) {
            // Upper Border
            if (point.getX() <= B.getX() && point.getY() <= B.getY()) {
                return true;
            }
        }
        return false;
    }
}
