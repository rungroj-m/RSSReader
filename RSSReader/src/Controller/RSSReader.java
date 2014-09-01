package Controller;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Model.*;

public class RSSReader {
	private Map<String, Item> map;
	private RSS rss;
	private Channel channel;
	private List<Item> items;
	public RSSReader(){
		map = new HashMap<String, Item>();
	}
	
	public void run(URL url) throws JAXBException {
		System.out.println(url);
		JAXBContext jaxbContext = JAXBContext.newInstance(RSS.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		rss = (RSS) unmarshaller.unmarshal(url);
		channel = rss.getChannel();
		items = channel.getItems();
		for (Item item : items) {
			System.out.println(item.getTitle());
			map.put(item.getTitle(), item);
		}
	}
	
	public String getTitle(){
		return channel.getTitle();
	}
	
	public Item findItem(String name){
		return map.get(name);
	}

	public List<Item> getItems(){
		return items;
	}

	
}
