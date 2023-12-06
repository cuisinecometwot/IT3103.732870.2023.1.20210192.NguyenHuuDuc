/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST	=
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE	=
			new MediaComparatorByCostTitle();
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media media = (Media) obj;
			if (this.id == media.id) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
	    ArrayList<Media> mediae = new ArrayList<>();
	    
	    CompactDisc cd = new CompactDisc(1,"Soledad", "Ballad", 12.5f);
	    DigitalVideoDisc dvd = new DigitalVideoDisc(3,"Final Fantasy X", "Fantasy", 222.22f );
	    Book book = new Book(2,"Operating System Concepts", "ICT", 30f);
	    
	    // Add some media objects to the list
	    mediae.add(cd);
	    mediae.add(dvd);
	    mediae.add(book);
	    
	    Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);    
	    
	    for (Media media : mediae) {
	        System.out.println(media.toString());
	    }
	}
}


