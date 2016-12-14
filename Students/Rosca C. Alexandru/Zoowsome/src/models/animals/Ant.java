package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Ant extends Insect{
	
	private int lvlPainBite;
	
	
	public Ant(){
		super(0.5 , 0.2);
		this.setNrOfLegs(10);
		this.setName("Ant");
		this.setCanFly(false);
		this.setDangerous(true);
		setLvlPainBite(5);
		
	}
	
	
	public Ant(int lvlPainBite, boolean canFly, boolean isDangerous){
		super(0.5, 0.2);
		setNrOfLegs(10);
		setName("Ant");
		this.setLvlPainBite(lvlPainBite);
		this.isDangerous = isDangerous;
		this.canFly = canFly;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.ANT);
	}
	
	public int getLvlPainBite() {
		return lvlPainBite;
	}

	public void setLvlPainBite(int lvlPainBite) {
		this.lvlPainBite = lvlPainBite;
	}


	@Override
	public void decodeFromXml(Element element) {  
		setLvlPainBite(Integer.valueOf(element.getElementsByTagName("lvlPainBite").item(0).getTextContent()));  	
 	}  
	
}
