package my.oopWork;

public class Triangle extends Shape {
    private double angle;
    private double aLength;
    private double bLength;

    public Triangle(double angle, double aLength, double bLength) {
        this.angle = angle;
        this.aLength = aLength;
        this.bLength = bLength;
    }

    @Override
    public double area() {
        return (aLength * bLength * Math.sin(Math.toRadians(angle))) / 2;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getaLength() {
        return aLength;
    }

    public void setaLength(double aLength) {
        this.aLength = aLength;
    }

    public double getbLength() {
        return bLength;
    }

    public void setbLength(double bLength) {
        this.bLength = bLength;
    }

    public Triangle() {
    }
}
