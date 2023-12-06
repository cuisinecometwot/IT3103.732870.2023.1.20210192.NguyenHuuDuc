/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println(media.getTitle()+ " has been added to the store.");
    }

    public void removeMedia(Media media) {
	    boolean found = false; 
	    for (Media item : itemsInStore) {
	        if (item.equals(media)) {
	        	itemsInStore.remove(item);
	            System.out.println(media.getTitle() + " has been removed from the store.");
	            found = true;
	            break;
	        }
	    }
	    if (!found) System.out.println(media.getTitle() + " is not in the store.");
	}
    public ArrayList<Media> getItemsInStore() {return itemsInStore;}
}