package HomeWork2;

/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class Circle extends Shape {

    private double R;
    final static double PI = 3.14;

    public Circle (double R) {

        this.R = R;
    }

    @Override
    public double area() {
        return PI * R * R;
    }

    @Override
    public double perimetr() {
        return 2 * PI * R;
    }

    @Override
    public void showResults() {

        System.out.println("Circle area = " + area());
        System.out.println("Circle perimetr = " + perimetr());

    }
}
