package controller;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.*;
/**
 * Controller get URL from GUI to unmarshall and provides data to rss. 
 * @author Rungroj Maipradit 5510546654
 */
public class RSSReaderController {
	/** Map between item's name and item. */
	private Map<String, Item> map;
	/** Refer to RSS. */
	private RSS rss;
	/** Refer to channel. */
	private Channel channel;
	/** Refer to items. */
	private List<Item> items;
	/**
	 * Constructor of this class use for initialize map.
	 */
	public RSSReaderController(){
		map = new HashMap<String, Item>();
	}
	
	/**
	 * Unmarshal url for rss ,channel,items.
	 * @param url url that use for unmarshal.
	 * @throws JAXBException
	 */
	public void run(URL url) throws JAXBException {
		System.out.println(url);
		JAXBContext jaxbContext = JAXBContext.newInstance(RSS.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		rss = (RSS) unmarshaller.unmarshal(url);
		channel = rss.getChannel();
		items = channel.getItems();
		for (Item item : items) {
			map.put(item.getTitle(), item);
		}
	}
	
	/**
	 * Return title of channel.
	 * @return title of channel
	 */
	public String getTitle(){
		return channel.getTitle();
	}
	
	/**
	 * Return item that match in map.
	 * @param name that match with item's name
	 * @return
	 */
	public Item findItem(String name){
		return map.get(name);
	}
	
	/**
	 * Return all items.
	 * @return all items
	 */
	public List<Item> getItems(){
		return items;
	}

	
}
