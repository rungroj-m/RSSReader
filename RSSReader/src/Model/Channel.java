package Model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
	private String title;
	@XmlElement(name="item")
	private List<Item> items;
	protected Channel(){
		this("", null);
	}
	
	public Channel(String title,List<Item> items){
		this.title =title;
		this.items = items;
	}
	
	public String getTitle(){
		return title;
	}
	
	public List<Item> getItems(){
		return items;
	}
}
