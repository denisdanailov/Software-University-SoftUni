package polymorphism.lab.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected abstract void  calculatePerimeter();
    protected abstract void calculateArea();

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
