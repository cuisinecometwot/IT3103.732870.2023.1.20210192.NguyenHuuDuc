import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("From DucNH210192 ...");
		System.out.println("What's your name?");
		String strName = input.nextLine();
		System.out.println("How old are you?");
		int iAge = input.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = input.nextDouble();
		System.out.println("Mr/Mrs. "+strName+", "+iAge+" year(s) old. Your height is "+dHeight+"m.");
		System.exit(0);
	}
}
