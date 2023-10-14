import java.util.Scanner;
import javax.swing.JOptionPane;
// Nguyen Huu Duc - 20210192
public class LinearEquation {
    public static void main(String[] args) {
        System.out.println("Linear equation with one variable (ax + b = 0) by DucNH210192");
        Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("a = ");
			double a = input.nextDouble();
			System.out.print("b = ");
			double b = input.nextDouble();
			System.out.println();
			if (a == 0) {
				if (b == 0) System.out.println("Infinite solutions!");
				else System.out.println("No Solution!"); 
			} else System.out.println("Solution of equation: x = " + (-b/a));
			int option = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Yes", "No"}, null);
			if (option!=JOptionPane.YES_OPTION) break;
		}
		input.close();
		System.exit(0);
    }
}
