/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.dvd.DigitalVideoDisc;
public class TestPassingParameter {
	public static void main (String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD's title: "+jungleDVD.getTitle());
		System.out.println("Cinderella DVD's title: "+cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle DVD's title: "+jungleDVD.getTitle());
	}
	
	/*public static void swap(Object o1, Object o2){
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}*/
	// A swap() method that can correctly swap the two objects.
	// Idea: Swap attributes of two objects
    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
        String tmp = o1.getTitle();
        o1.setTitle(o2.getTitle());
        o2.setTitle(tmp);
    }

	public static void changeTitle(DigitalVideoDisc dvd, String title){
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
}

