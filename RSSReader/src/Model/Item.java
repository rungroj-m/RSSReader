package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Item contains item element.
 * @author Rungroj Maipradit 5510546654
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	/** Title of item. */
	private String title;
	/** Description of item. */
	private String description;
	/** Link of item. */
	private String link;
	/** Publish date of item. */
	private String pubDate;
	
	/**
	 * Constructor of this class.
	 */
	protected Item() {
		this("", "", "", "");
	}
	
	/**
	 * Constructor of this class.
	 * @param title that refer to item name
	 * @param description item description
	 * @param link of this item
	 * @param pubDate publish date of this item
	 */
	public Item(String title,String description,String link,String pubDate) {
		this.title = title;
		this.description = description;
		this.link = link;
		this.pubDate = pubDate;
	}
	
	/**
	 * Return title of this item
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Return item description.
	 * @return item description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Return item link.
	 * @return link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Return publish date.
	 * @return publish date.
	 */
	public String getPubDate() {
		return pubDate;
	}
}
