/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870 
 */
public class CartTest {
	public static void main(String[] args){
		System.out.println("=======================================");
		System.out.println("======AIMS Project by DucNH210192======");
		System.out.println("=======================================\n");

		Cart anOrder = new Cart();
		DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 14.2f);
		dvdList[1] = new DigitalVideoDisc("24時間シンデレラ", "Fantasy", "真島吾朗", 4, 17.5f);
		dvdList[2] = new DigitalVideoDisc("The Dark Knight", "Superhero", "Christopher Nolan", 152, 15.2f);
		anOrder.addDigitalVideoDisc(dvdList[0]);
		anOrder.addDigitalVideoDisc(dvdList[1], dvdList[2]);

		// print items in cart and total cost
		anOrder.printCart();
		anOrder.searchCart("シンデレラ");
		anOrder.searchCart(1);
	}
}
