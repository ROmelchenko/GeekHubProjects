package HomeWork2;

/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class Rectangle extends Shape {

    private double a, b;
    private Triangle triangleInRectangle;

    public Rectangle(double a, double b){

        this.a = a;
        this.b = b;
        triangleInRectangle = new Triangle(a, b, Math.sqrt(a * a + b * b));
    }

    @Override
    public double area() {

        return a * b;
    }

    @Override
    public double perimetr() {

        return (a + b) * 2;
    }

    @Override
    public void showResults() {

        System.out.println("Rectangle area = " + area());
        System.out.println("Rectangle perimetr = " + perimetr());
        System.out.println("Triangle result: ");
        triangleInRectangle.showResults();
    }


}
