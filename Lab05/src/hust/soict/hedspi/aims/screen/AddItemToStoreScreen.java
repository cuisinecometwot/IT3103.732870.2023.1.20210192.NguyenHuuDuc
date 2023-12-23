package hust.soict.hedspi.aims.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public AddItemToStoreScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreScreen(store, cart);
			}
		});
	}

}