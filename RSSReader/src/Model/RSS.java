package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RSS {
	private Channel channel;
	
	protected RSS() {
		this(null);
	}
	
	public RSS(Channel channel){
		this.channel = channel;
	}

	public Channel getChannel() {
		return channel;
	}


}
