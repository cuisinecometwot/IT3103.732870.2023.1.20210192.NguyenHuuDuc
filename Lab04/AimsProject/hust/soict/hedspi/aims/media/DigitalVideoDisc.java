/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	//toString method
	public String toString() {
		return "ID - " +getId()+ ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "s - $" + getCost();
	}
}

