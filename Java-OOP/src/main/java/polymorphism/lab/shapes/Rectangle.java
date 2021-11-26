package polymorphism.lab.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle (Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        Double perimeter = 2 * (height + width);
        super.setPerimeter(perimeter);
    }

    @Override
    protected void calculateArea() {
        Double area = height * width;
        super.setArea(area);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
