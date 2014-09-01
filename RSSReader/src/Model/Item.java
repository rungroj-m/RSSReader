package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	private String title;
	private String description;
	private String link;
	private String pubDate;
	
	protected Item() {
		this("", "", "", "");
	}
	
	public Item(String title,String description,String link,String pubDate) {
		this.title = title;
		this.description = description;
		this.link = link;
		this.pubDate = pubDate;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getLink() {
		return link;
	}
	public String getPubDate() {
		return pubDate;
	}
}
