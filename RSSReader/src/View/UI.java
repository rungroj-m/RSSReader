package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
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

public class UI extends JFrame{
	private JPanel outer;
	private JPanel inner;
	private JPanel top;
	private JPanel mid;
	private JButton button;
	private JLabel link;
	private JTextField input;
	private JTextArea desc;
	private JComboBox<String> list;
	private JLabel title;
	private RSSReader rssReader;
	
	private void iniComponent(){
		outer = new JPanel(new BorderLayout());
		top = new JPanel(new FlowLayout());
		input = new JTextField("         ");
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
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

	public void search(String text) {
		try {
			rssReader.run(new URL(text));
			setItem();
		} catch (MalformedURLException | JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void setItem(){
		title.setText(rssReader.getTitle());
		clear();
		for(Item item : rssReader.getItems()){
			list.addItem(item.getTitle());
		}
	}
	public void clear(){
		list.removeAllItems();
	}
}
