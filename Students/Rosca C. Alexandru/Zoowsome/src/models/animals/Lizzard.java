package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Lizzard extends Reptile{
	
	private int color ;
	
	public Lizzard(){
		super(0.3, 0.15);
		this.setName("Lizzard");
		this.setNrOfLegs(4);
		this.setLaysEggs(true);
		this.setColor(140);
	}
	
	
	public Lizzard(int color, boolean laysEggs){
		super(0.3, 0.15);
		setName("Lizzard");
		setNrOfLegs(4);
		this.color = color;
		this.laysEggs = laysEggs;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.LIZZARD);
	}
	
	public void decodeFromXml(Element element) {  
		setColor(Integer.valueOf(element.getElementsByTagName("color").item(0).getTextContent()));  	
 	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
