package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Channel contains items and title.
 * @author Rungroj Maipradit 5510546654
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
	/** Title of channel. */
	private String title;
	/** List of all items. */
	@XmlElement(name="item")
	private List<Item> items;
	/**
	 * Constructor of this class.
	 */
	protected Channel(){
		this("", null);
	}
	
	/**
	 * Constructor of this class.
	 * @param title of channel
	 * @param items all item in channel
	 */
	public Channel(String title,List<Item> items){
		this.title =title;
		this.items = items;
	}
	
	/**
	 * Return channel title
	 * @return title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Return all items.
	 * @return all items
	 */
	public List<Item> getItems(){
		return items;
	}
}
