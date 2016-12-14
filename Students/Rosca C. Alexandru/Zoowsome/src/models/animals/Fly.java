package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Fly extends Insect{
	
	private int lifeTime;
	
	public Fly(){
	  	super(0.1, 0);
		this.setNrOfLegs(6);
		this.setName("Fly");
		this.setDangerous(false);
		this.setCanFly(true);
		setLifeTime(2);
	}
	
	public Fly(int lifeTime, boolean canFly, boolean isDangerous){
		super(0.1, 0);
		setNrOfLegs(6);
		setName("Fly");
		this.setLifeTime(lifeTime);
		this.isDangerous = isDangerous;
		this.canFly = canFly;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.FLY);
	}
	
	
	public void decodeFromXml(Element element) {  
		setLifeTime(Integer.valueOf(element.getElementsByTagName("lifeTime").item(0).getTextContent()));  	
 	}
	
	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}
}
