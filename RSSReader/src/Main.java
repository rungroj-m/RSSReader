import java.awt.Dimension;

import Controller.RSSReader;
import View.UI;


public class Main {

	public static void main(String[] args) {
		UI ui = new UI(new RSSReader());
		ui.setVisible(true);
		ui.pack();
		ui.setSize(new Dimension(1000,500));
	}

}
