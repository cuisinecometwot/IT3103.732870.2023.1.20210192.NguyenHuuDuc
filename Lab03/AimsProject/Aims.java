/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
public class Aims {
	public static void main(String[] args){
		System.out.println("=======================================");
		System.out.println("======AIMS Project by DucNH210192======");
		System.out.println("=======================================\n");
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to cart
		/*
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		//anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		//anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		//anOrder.addDigitalVideoDisc(dvd3);
		*/
		
		DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 14.2f);
		dvdList[1] = new DigitalVideoDisc("24時間シンデレラ", "Fantasy", "真島吾朗", 4, 17.5f);
		dvdList[2] = new DigitalVideoDisc("The Dark Knight", "Superhero", "Christopher Nolan", 152, 15.2f);
		anOrder.addDigitalVideoDisc(dvdList[0]);
		anOrder.addDigitalVideoDisc(dvdList[1], dvdList[2]);

		// print items in cart and total cost
		anOrder.printCart();
	}
}
