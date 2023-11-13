/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; 
    // init cart
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    // current number of DVDs
    private int qtyOrdered;
    
    // Original add disc to cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
    	// while cart is not full ...
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println(disc.getTitle()+" has been added!");
        } else System.out.println("Cannot add more DVDs! The cart is almost full.");
    }
    
    // Overloading version
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println(disc.getTitle() + " has been added!");
			} else System.out.println("Cannot add more DVDs! The cart is almost full.");
		}
	}
    
    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
		for (DigitalVideoDisc disc : discs) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
					System.out.println(disc.getTitle() + " has been added!");
			} else System.out.println("Cannot add more DVDs! The cart is almost full.");
		}
	}
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
		if(itemsOrdered[0] ==  null) {
            System.out.println("[ERROR] Your cart is empty!");
            return;
        }
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].equals(disc)){
				// remove and rearrange
                for (int j = i; j < qtyOrdered - 1; j++) itemsOrdered[j] = itemsOrdered[j + 1];
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println(disc.getTitle()+" has been removed!");
                return;
            }
        }
        // disc not found
        System.out.println("[ERROR] No such DVD exists!");
    }
    
    // return total cost
    public float totalCost(){
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) total += itemsOrdered[i].getCost();
        return total;
    }
    
    // return cart's info
    public String toString(){
    	String result = "";
        for (int i = 0; i < qtyOrdered; i++) {
            result += itemsOrdered[i].toString();
            result += "\n";
        }
        return result;
    }

    
}

