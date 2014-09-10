import java.awt.Dimension;

import view.GUI;
import controller.RSSReaderController;

/**
 * Main of this program.
 * @author Rungroj Maipradit 5510546654
 */
public class Main {
	
	/**
	 * Create gui and put controller in it.
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI(new RSSReaderController());
		gui.setVisible(true);
		gui.pack();
		gui.setSize(new Dimension(1000,500));
	}

}
