/* Student: Nguyen Huu Duc - 20210192
 * Class: 732870
 */
package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.media.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public static void main(String[] args) throws Exception {
		// Test
		Store myStore = new Store();
		Cart myCart = new Cart();
		// Create media
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Goblin King", "Animation", "Someone", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Track track1 = new Track("Wei", 10);
		Track track2 = new Track("Shu", 21);
		Track track3 = new Track("Wu");
		CompactDisc cd1 = new CompactDisc("ROTK OST (Part 1)", "Drama", "Various", 30.95f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("ROTK OST (Part 2)", "Drama", "Various", 25.99f);
		cd2.addTrack(track3);
		/*
		Media dvd1 = new DigitalVideoDisc("Movie 01", "Genre A", "Director", 30, 10.15f);
		Media dvd2 = new DigitalVideoDisc("Movie 02", "Genre A", "Also Director", 45, 8.30f);
		Media dvd3 = new DigitalVideoDisc("Movie 03", "Genre B", 50f);
		Track track1 = new Track("Track01", 3);
		Track track2 = new Track("Track02", 4);
		Track track3 = new Track("Track03");
		CompactDisc cd1 = new CompactDisc("Album 1", "Category A", "Artist X", "Someone", 10.20f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("Album 2", "Category B", "Artist Y", "Various", 11.90f);
		cd2.addTrack(track1);
		cd2.addTrack(track2);
		cd2.addTrack(track3);
		*/
		Book book1 = new Book("Java Handbook", "Java", 990, 5f);
		book1.addAuthor("Wei Zhu");
		Media dvd4 = new DigitalVideoDisc("Movie 04", "Genre C", "Director", 120, 12.90f);
		Media dvd5 = new DigitalVideoDisc("Movie 05", "Genre D", "Director", 90, 9.9f);
		Media dvd6 = new DigitalVideoDisc("Movie 06", "Genre C", "Director", 100, 11.88f);
		Media dvd7 = new DigitalVideoDisc("Movie 07", "Genre E", "Director", 89, 8.68f);
		Media dvd8 = new DigitalVideoDisc("Movie 08", "Genre F", "Also Director", 180, 20.1f);
		Media dvd9 = new DigitalVideoDisc("Movie 09", "Genre F", "Also Director", 160, 18.4f);

		// Try adding DVDs
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd2);
		myStore.addMedia(dvd3);
		myStore.addMedia(cd1);
		myStore.addMedia(cd2);
		myStore.addMedia(book1);
		myStore.addMedia(dvd4);
		myStore.addMedia(dvd5);
		myStore.addMedia(dvd6);
		myStore.addMedia(dvd7);
		myStore.addMedia(dvd8);
		myStore.addMedia(dvd9);
		new StoreScreen(myStore, myCart);
	}

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		setLocation(x, y);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 5, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media, cart);
			center.add(cell);
		}
		return center;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new AddBookListener());
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new AddCDListener());
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new AddDVDListener());
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem cart = new JMenuItem("View cart");
		cart.addActionListener(new ViewCartListener());
		menu.add(cart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS:~$ DucNH210192");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(new ViewCartListener());

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	private class ViewCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new CartScreen(store, cart);
			dispose();
		}

	}

	private class AddDVDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddDVDToStoreScreen(store, cart);
			dispose();
		}

	}

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddBookToStoreScreen(store, cart);
			dispose();
		}

	}

	private class AddCDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddCDToStoreScreen(store, cart);
			dispose();
		}

	}

}