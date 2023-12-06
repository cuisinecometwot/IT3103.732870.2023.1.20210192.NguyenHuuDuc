/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMBER_ORDERED);
	
	public void addMedia(Media media) {
		if (itemsOrdered.size()<MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle()+" has been added to the cart.");
		}
		else System.out.println("The cart is full.");
	}
	
	public void removeMedia(Media media) {
	    boolean found = false; 
	    for (Media item : itemsOrdered) {
	        if (item.equals(media)) {
	            itemsOrdered.remove(item);
	            System.out.println(media.getTitle() + " has been removed from the cart.");
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println(media.getTitle() + " is not in the cart.");
	    }
	}
	
	public ArrayList<Media> getItemsInCart(){
		return itemsOrdered;
	}
	
	//Get total cost
	public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

	//Print cart method
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: $" + totalCost());
		System.out.println("***************************************************");
	}

	//Search for DVDs in the cart by ID and display them
	//Notify to user if no match is found
	public void searchID(int id){
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				found = true;
				System.out.println("DVD found: ");
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) System.out.println("No match is found!");
	}

	//Search for DVDs in the cart by title and display them
	//Notify to user if no match is found
	public void searchTitle(String title){
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				found = true;
				System.out.println("DVD found: ");
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) System.out.println("No match is found!");
	}
}