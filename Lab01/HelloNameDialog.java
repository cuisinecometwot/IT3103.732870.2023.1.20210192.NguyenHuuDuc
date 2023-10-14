// Example 3: HelloNameDialog.java
// Input Dialog
// Nguyen Huu Duc - 20210192
import javax.swing.JOptionPane;

public class HelloNameDialog {
	public static void main(String args[]){
		String result;
		result = JOptionPane.showInputDialog("Message from 20210192: Please enter your name: ");
		JOptionPane.showMessageDialog(null,"Hi " + result + "! I'm Nguyen Huu Duc.");
		System.exit(0);
	}
}
