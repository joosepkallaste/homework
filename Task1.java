public class Cirkle {
    private double radius;
    public Cirkle() {
        this.radius = 1.0;
    }
    public Cirkle(double radius) {
        this.radius = radius;

    }
    public double getRadius() {
        return radius;

    }
    public double getArea() {
        return Math.PI * radius *radius;

    }


}
