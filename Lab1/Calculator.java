import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // get input from user
        System.out.print("(DucNH210192) Enter the first number: ");
        double a = input.nextDouble();
        System.out.print("(DucNH210192) Enter the second number: ");
        double b = input.nextDouble();
        input.close();
        // Sum of the numbers
        System.out.printf("Sum of the numbers: %5.3f\n", a+b);
        // Difference of the numbers
        System.out.printf("Difference of the numbers: %5.3f\n", a-b);
        // Product of the numbers
        System.out.printf("Product of the numbers: %5.3f\n", a*b);
        // Quotient of the numbers
        System.out.printf("Quotient of the numbers: %5.3f\n", a/b);
        System.exit(0);
    }
}
