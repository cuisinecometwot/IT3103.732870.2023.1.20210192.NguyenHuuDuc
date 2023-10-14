import java.util.Scanner; // Nguyen Huu Duc - 20210192
public class LinearSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Linear system by DucNH210192");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");
        // Get input from users
        System.out.print("Enter a11, a12, b1: ");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        System.out.print("Enter a21, a22, b2: ");
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        scanner.close();
        double det = a11 * a22 - a21 * a12; // calculate the determinant
        double dx = (a22 * b1 - a12 * b2);
		double dy = (a11 * b2 - a21 * b1);
        if (det == 0){
			if (dx!=dy) System.out.println("Infinite solutions!");
			else System.out.println("No unique solution!");
		} else {
			double x1 = dx / det;
			double x2 = dy / det;
			System.out.println("x1 = " + x1 + ", x2 = " + x2);
		}
		System.exit(0);
    }
}
