package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;

import Controller.RSSReader;
import Model.Item;
/**
 * UI of this program.
 * @author Rungroj Maipradit 5510546654
 */
public class UI extends JFrame{
	/** Outer panel. */
	private JPanel outer;
	/** Inner panel. */
	private JPanel inner;
	/** Top panel in outer. */
	private JPanel top;
	/** Top panel in inner. */
	private JPanel mid;
	/** Search button. */
	private JButton button;
	/** Contain link. */
	private JLabel link;
	/** Receive input. */
	private JTextField input;
	/** Show description of selected item. */
	private JTextArea desc;
	/** Show all items. */
	private JComboBox<String> list;
	/** Show title of this RSS feeder. */
	private JLabel title;
	/** Refer to rssReader. */
	private RSSReader rssReader;
	/**
	 * Initial UI Component.
	 */
	private void iniComponent(){
		outer = new JPanel(new BorderLayout());
		top = new JPanel(new FlowLayout());
		input = new JTextField("");
		input.setPreferredSize(new Dimension(200,30));
		button = new JButton("Search");
		top.add(input);
		top.add(button);
		outer.add(top,BorderLayout.NORTH);
		inner = new JPanel(new BorderLayout());
		outer.add(inner,BorderLayout.CENTER);
		mid = new JPanel(new FlowLayout());
		title = new JLabel("     ");
		list = new JComboBox<String>();
		mid.add(title);
		mid.add(list);
		inner.add(mid,BorderLayout.NORTH);
		desc = new JTextArea("        ");
		desc.setLineWrap(true);
		desc.setEditable(false);
		inner.add(desc,BorderLayout.CENTER);
		link = new JLabel();
		outer.add(link,BorderLayout.SOUTH);
		add(outer);
	}
	
	/**
	 * Constructor of this class Contain UI and actionListener.
	 * @param rssReader controller
	 */
	public UI(RSSReader rssReader){
		this.rssReader = rssReader;
		
		iniComponent();
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search(input.getText());
				
			}
		});
		
		list.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				findItem(list.getSelectedItem().toString());
			}
		});

		link.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
		        try {
					Desktop.getDesktop().browse(new URI(link.getText()));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	public void findItem(String name) {
		Item item = rssReader.findItem(name);
		desc.setText(item.getDescription() +"\n"+item.getPubDate());
		link.setText(item.getLink());
	}

	/**
	 * Use for search all items from input.
	 * @param text URL that use for search.
	 */
	public void search(String text) {
		try {
			rssReader.run(new URL(text));
			setItem();
		} catch (MalformedURLException | JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Set text in title and list.
	 */
	public void setItem(){
		title.setText(rssReader.getTitle());
		clear();
		for(Item item : rssReader.getItems()){
			list.addItem(item.getTitle());
		}
	}
	/**
	 * Remove old list item.
	 */
	public void clear(){
		list.removeAllItems();
	}
}
