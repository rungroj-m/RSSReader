package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * RSS contains channel.
 * @author Rungroj Maipradit 5510546654
 */
public class RSS {
	/** contains channel. */
	private Channel channel;
	
	/** default constructor. */
	protected RSS() {
		this(null);
	}
	
	/**
	 * constructor set channel.
	 * @param channel
	 */
	public RSS(Channel channel){
		this.channel = channel;
	}

	/**
	 * Return channel
	 * @return channel
	 */
	public Channel getChannel() {
		return channel;
	}


}
