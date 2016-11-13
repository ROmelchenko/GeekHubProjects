package HomeWork2;

/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class Square extends Shape {

    private double a;

    public Square (double a){

        this.a = a;
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimetr() {
        return a * 4;
    }

    @Override
    public void showResults() {

        System.out.println("Square area = " + area());
        System.out.println("Square perimetr = " + perimetr());
    }
}
