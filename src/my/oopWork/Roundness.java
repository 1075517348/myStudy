package my.oopWork;

public class Roundness extends Shape {
    private double radius;

    public Roundness(double radius) {
        this.radius = radius;
    }

    public Roundness() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

}
