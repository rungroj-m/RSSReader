import java.awt.Dimension;

import Controller.RSSReader;
import View.UI;

/**
 * Main of this program.
 * @author Rungroj Maipradit 5510546654
 */
public class Main {
	
	/**
	 * Main of this program use to create UI.
	 * @param args
	 */
	public static void main(String[] args) {
		UI ui = new UI(new RSSReader());
		ui.setVisible(true);
		ui.pack();
		ui.setSize(new Dimension(1000,500));
	}

}
