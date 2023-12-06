/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aims {
	static Store store = new Store();
	static Cart cart = new Cart();
	
	//user interface
	public static void showMenu() {
		System.out.println("Hi Nguyen Huu Duc (20210192),");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1.View store");
		System.out.println("2.Update store");
		System.out.println("3.See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Hi Nguyen Huu Duc (20210192),");
		System.out.println("Options");
		System.out.println("--------------------------------");
		System.out.println("1.See a media's details");
		System.out.println("2.Add a media to cart");
		System.out.println("3.Play a media");
		System.out.println("4.See current cart");
		System.out.println("0.Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void mediaDetailsMenu(Media media) {
		System.out.println("Hi Nguyen Huu Duc (20210192),");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (media instanceof Disc) {
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		else {
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1");
		}
	}
	public static void cartMenu() {
		System.out.println("Hi Nguyen Huu Duc (20210192),");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	//view Store and Cart methods
	public static void viewStore(Scanner aims) {
	    for (Media media : store.getItemsInStore()) {
	        System.out.println(media.toString());
	    }
	    storeMenu();
	    while (true) {
	        System.out.println("Enter your option:"); // Add this prompt
	        int option = aims.nextInt();
	        aims.nextLine();
	        switch (option) {
	            case 1:
	                seeMediaDetails(aims);
	                storeMenu();
	                break;
	            case 2:
	                addMediaCart(aims);
	                storeMenu();
	                break;
	            case 3:
	                playMedia(aims, store);
	                storeMenu();
	                break;
	            case 4:
	                seeCurrentCart(aims);
	                break;
	            case 0:
	                System.out.println("Back to AIMS...");
	                showMenu();
	                return;
	            default:
	                System.out.println("Invalid option. Please try again.");
	                break;
	        }
	    }
	}

	public static void seeCurrentCart(Scanner aims) {
	    cartMenu();
	    while (true) {
	        System.out.println("Enter your option:"); // Add this prompt
	        int option = aims.nextInt();
	        aims.nextLine();
	        switch (option) {
	            case 1:
	                filterMediaCart(aims);
	                cartMenu();
	                break;
	            case 2:
	                sortMediaCart(aims);
	                cartMenu();
	                break;
	            case 3:
	                removeMediaCart(aims);
	                cartMenu();
	                break;
	            case 4:
	                playMedia(aims, cart);
	                cartMenu();
	                break;
	            case 5:
	                placeOrder();
	                break;
	            case 0:
	                System.out.println("Back to AIMS...");
	                showMenu();
	                return;
	            default:
	                System.out.println("Invalid option! Please try again.");
	                break;
	        }
	    }
	}

	//methods for store and cart
	public static void updateStore(Scanner aims) {
	    while (true) {
	        System.out.println("Enter 1 to add, 2 to remove media or 0 to back to Aims Menu.");
	        int option = aims.nextInt();
	        aims.nextLine();
	        switch (option) {
	            case 1:
	                System.out.println("Please enter the basic details of the Media...");
	                System.out.println("Media ID: ");
	                int id = aims.nextInt();
	                aims.nextLine();
	                System.out.println("Media title: ");
	                String title = aims.nextLine();
	                System.out.println("Media category: ");
	                String category = aims.nextLine();
	                System.out.println("Media cost: ");
	                float cost = aims.nextFloat();
	                aims.nextLine();
	                System.out.println("Kind of media: 1 for Disc, 2 for Book: ");
	                int kind = aims.nextInt();
	                aims.nextLine();
	                switch (kind) {
	                    case 1:
	                        Disc disc = new Disc(id, title, category, cost);
	                        store.addMedia(disc);
	                        break;
	                    case 2:
	                        Book book = new Book(id, title, category, cost);
	                        store.addMedia(book);
	                        break;
	                    default:
	                        System.out.println("It is not a kind of media!");
	                        break;
	                }
	                break;
	            case 2:
	                System.out.println("Please enter the media's title: ");
	                String titleRemove = aims.nextLine();
	                int index = findIndex(titleRemove, store);
	                if (index == -1) {
	                    System.out.println("The media is not in the store!");
	                } else {
	                    store.removeMedia(store.getItemsInStore().get(index));
	                }
	                break;
	            case 0:
	            	showMenu();
	            	return;
	            default:
	                System.out.println("Invalid option! Please try again.");
	                break;
	        }
	    }
	}

	public static void seeMediaDetails(Scanner aims) {
		System.out.println("Please enter the media's title: ");
		String title = aims.nextLine();
		int found = findIndex(title, store);
		if (found == -1) {
			System.out.println("Can not find the media!");
		}
		else {
			store.getItemsInStore().get(found).toString();
			mediaDetailsMenu(store.getItemsInStore().get(found));
		}
	}
	
	public static void addMediaCart(Scanner aims) {
		System.out.println("Please enter the media's title: ");
		String title = aims.nextLine();
		int found = findIndex(title, store);
		if (found == -1) {
			System.out.println("Can not find the media!");
		}
		else {
			cart.addMedia(store.getItemsInStore().get(found));
			System.out.println("Item has been added to the cart!");
		}
	}
	
	public static ArrayList<Media> filterMediaCart(Scanner aims) {
		ArrayList<Media> filteredList = new ArrayList<>();
		System.out.print("Choose an option to filter Media: ");
		System.out.println("1: By title, 2: By id: ");
		int option = aims.nextInt();
		aims.nextLine();
		while (true) {
			switch (option) {
			case 1:
				System.out.print("Please enter the title: ");
				String title = aims.nextLine();
				for (Media media: cart.getItemsInCart()) {
					if (media.getTitle().toLowerCase().contains(title.toLowerCase())){
						filteredList.add(media);
					}
				}
				return filteredList;
			case 2:
				System.out.print("Please enter the id: ");
				String id = aims.nextLine();
				for (Media media: cart.getItemsInCart()) {
					String idString = String.valueOf(media.getId());
					if (id.equals(idString)) {
						filteredList.add(media);
					}
				}
				return filteredList;
			}
		}
	}
	
	public static ArrayList<Media> sortMediaCart(Scanner aims) {
	    System.out.print("Please choose the option to sort media in cart: ");
	    System.out.println("1: By title, 2: By id");
	    int option;

	    while (true) {
	        option = aims.nextInt();
	        aims.nextLine();

	        switch (option) {
	            case 1:
	                Collections.sort(cart.getItemsInCart(), Media.COMPARE_BY_TITLE_COST);
	                return cart.getItemsInCart();
	            case 2:
	                Collections.sort(cart.getItemsInCart(), Media.COMPARE_BY_COST_TITLE);
	                return cart.getItemsInCart();
	            default:
	                System.out.println("Invalid option. Please try again.");
	                break;
	        }
	    }
	}

	public static void removeMediaCart(Scanner aims) {
		System.out.println("Please enter the media's title to remove: ");
		String title = aims.nextLine();
		int index = findIndex(title, cart);
			if (index!=-1) {
				cart.removeMedia(cart.getItemsInCart().get(index));
			}
			System.out.println("Can not find media in cart");	
	}
	
	public static void placeOrder() {
		System.out.println("Order is created!");
		cart.getItemsInCart().clear();
		showMenu();
	}
	
	//play media methods
	public static void playMedia(Scanner aims, Store store) {
		System.out.println("Please enter the media's title: ");
		String title = aims.nextLine();
		int found = findIndex(title, store);
		if (found == -1) {
			System.out.println("Can not find the media!");
		}
		else {
			if (store.getItemsInStore().get(found) instanceof DigitalVideoDisc) {
				DigitalVideoDisc disc = (DigitalVideoDisc) store.getItemsInStore().get(found);
				disc.play();
			}
			else if (store.getItemsInStore().get(found) instanceof CompactDisc) {
				CompactDisc disc = (CompactDisc) store.getItemsInStore().get(found);
				disc.play();
			}
			else {
				System.out.println("Can not play Book");
			}
		}
	}
	public static void playMedia(Scanner aims, Cart cart) {
		System.out.println("Please enter the media's title: ");
		String title = aims.nextLine();
		int found = findIndex(title, cart);
		if (found == -1) {
			System.out.println("Can not find the media!");
		}
		else {
			if (cart.getItemsInCart().get(found) instanceof DigitalVideoDisc) {
				DigitalVideoDisc disc = (DigitalVideoDisc) cart.getItemsInCart().get(found);
				disc.play();
			}
			else if (cart.getItemsInCart().get(found) instanceof CompactDisc) {
				CompactDisc disc = (CompactDisc) cart.getItemsInCart().get(found);
				disc.play();
			}
			else {
				System.out.println("Can not play Book");
			}
		}
	}
	
	//method to find the index of media
	public static int findIndex(String title, Store store) {
		for (int i = 0; i < store.getItemsInStore().size(); i++) {
			//if (title == store.getItemsInStore().get(i).getTitle()) {
			if (store.getItemsInStore().get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	public static int findIndex(String title, Cart cart) {
		for (int i = 0; i < cart.getItemsInCart().size(); i++) {
			// if (title == cart.getItemsInCart().get(i).getTitle()) {
			if (store.getItemsInStore().get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	//main
	public static void main(String[] args) {
		CompactDisc test = new CompactDisc(1, "Test", "test", 1f);
		CompactDisc cd = new CompactDisc(1,"The Fellowship of the Ring","Fantasy", 12.5f);
	    DigitalVideoDisc dvd = new DigitalVideoDisc(2,"The Two Towers", "Fantasy", 222.22f );
	    Book book = new Book(3,"The Return of the King", "Fantasy", 30f);
	    store.addMedia(cd); store.addMedia(dvd); store.addMedia(book);
	    store.addMedia(test);
	    cart.addMedia(test);
	    //for (Media item : store.getItemsInStore()) {
	    	//System.out.println(item.toString());
	    //}
	    Scanner aims = new Scanner(System.in);
	    while (true) {
	        showMenu();
	        int option = aims.nextInt();
	        aims.nextLine();
	        switch (option) {
	            case 1:
	                viewStore(aims);
	                break;
	            case 2:
	                updateStore(aims);
	                break;
	            case 3:
	                seeCurrentCart(aims);
	                break;
	            case 0:
	                System.out.println("Exiting the application...");
	                aims.close(); 
	                return;
	            default:
	                System.out.println("Invalid option. Please try again.");
	                break;
	        }
	    }
	}
}