import javax.swing.JOptionPane;
// Nguyen Huu Duc - 20210192
// Choosing only "Yes" or "No"
public class ChoosingOption {
	public static void main(String[] args){
		int option = JOptionPane.showOptionDialog(null,"DucNH210192: Do you want to change to the first class ticket?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Yes", "No"}, null);
		JOptionPane.showMessageDialog(null,"DucNH210192: You've chosen "+(option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
