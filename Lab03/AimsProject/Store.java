/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int numberOfItems;

    public Store(int maxSize) {
        itemsInStore = new DigitalVideoDisc[maxSize];
        numberOfItems = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (numberOfItems < itemsInStore.length) {
            itemsInStore[numberOfItems] = dvd;
            numberOfItems++;
            System.out.println("ADDED: " + dvd.getTitle());
        } else {
            System.out.println("Max capacity of DVDs reached!");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean check = false; // check if DVD already exists
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].equals(dvd)) {
                check = true;
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                numberOfItems--;
                System.out.println("REMOVED: " + dvd.getTitle());
                break;
            }
        }
        if (!check) System.out.println("DVD not found: " + dvd.getTitle());
    }

    public void displayStore() {
        System.out.println("********** STORE **********");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println(itemsInStore[i].toString());
        }
        System.out.println("***************************");
    }
}
