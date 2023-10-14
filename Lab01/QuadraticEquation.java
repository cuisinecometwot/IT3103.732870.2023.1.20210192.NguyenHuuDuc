import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class QuadraticEquation{
	public static void main(String[] args){
		System.out.println("Quadratic equation (ax^2 + bx + c = 0) by DucNH210192");
		// Get user's input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a: ");
		double a = input.nextDouble();
		System.out.print("Enter b: ");
		double b = input.nextDouble();
		System.out.print("Enter c: ");
		double c = input.nextDouble();
		double d= b*b-4*a*c; // calculate Delta
		if (a==0) {
			if (b == 0) {
				if (c == 0) System.out.println("Infinite solutions!");
				else System.out.println("No Solution!"); 
			} else System.out.println("The root is " + (-c/b));
		}
		else if (d>0.0){
			double r1 = (-b+Math.pow(d, 0.5))/(2*a);
			double r2 = (-b-Math.pow(d, 0.5))/(2*a);
			System.out.println("The roots are " + r1 + " and " + r2);
		} else if (d==0.0){ 
			double r1 = -b/(2*a);  
			System.out.println("The root is " + r1);  
		} else System.out.println("No Solution!");  
		System.exit(0);
	}  
}  
