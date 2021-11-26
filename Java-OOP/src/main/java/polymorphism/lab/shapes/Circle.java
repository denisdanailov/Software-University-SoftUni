package polymorphism.lab.shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        Double perimeter = 2 * Math.PI * radius;
        super.setPerimeter(perimeter);
    }

    @Override
    protected void calculateArea() {
        Double area = Math.PI * Math.pow(radius, 2);
        super.setArea(area);
    }

    public final Double getRadius() {
        return radius;
    }
}
