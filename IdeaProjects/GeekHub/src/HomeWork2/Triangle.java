package HomeWork2;

/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class Triangle extends Shape {

    private double a, b, c, P, S;


    public Triangle(double a, double b, double c) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.P = (a + b + c) / 2;
        this.S = Math.sqrt(P * (P - a) * (P - b) * (P - c));
    }

    @Override
    public double area() {
        return S;
    }

    @Override
    public double perimetr() {
        return P;
    }

    @Override
    public void showResults() {

        System.out.println("Triangle area = " + area());
        System.out.println("Triangle perimetr = " + perimetr());
    }


}
