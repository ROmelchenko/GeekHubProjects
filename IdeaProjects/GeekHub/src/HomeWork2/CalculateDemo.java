package HomeWork2;

import java.util.Scanner;

/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class CalculateDemo {

    public static void main(String[] args) {

    Scanner scanner;
    String str = "";

    while (!str.equals("EXIT")) {

        System.out.println("Choose shape what you want: CIRCLE, SQUARE, TRIANGLE or RECTANGLE");

        scanner = new Scanner(System.in);
        str = scanner.nextLine();

        switch (Shapes.valueOf(str)) {

            case CIRCLE:
                System.out.println("Input radius of circle : ");
                int R = scanner.nextInt();

                Circle circle = new Circle(R);
                System.out.println("Result : \n");
                circle.showResults();
                System.out.println();
                break;

            case SQUARE:
                System.out.println("Input side a : ");
                int a1 = scanner.nextInt();

                Square square = new Square(a1);
                System.out.println("Result : \n");
                square.showResults();
                System.out.println();
                break;

            case TRIANGLE:
                System.out.println("Input side a : ");
                double a = scanner.nextInt();

                System.out.println("Input side b : ");
                double b = scanner.nextInt();

                System.out.println("Input side c : ");
                double c = scanner.nextInt();

                Triangle triangle = new Triangle(a, b, c);
                System.out.println("Result : \n");
                triangle.showResults();
                System.out.println();
                break;

            case RECTANGLE:
                System.out.println("Input side a : ");
                int a2 = scanner.nextInt();

                System.out.println("Input side b : ");
                int b2 = scanner.nextInt();

                Rectangle rectangle = new Rectangle(a2, b2);
                System.out.println("Rectangle result : \n");
                rectangle.showResults();
                System.out.println();
                break;

            case EXIT:
                break;
            }
        }
    }
}
