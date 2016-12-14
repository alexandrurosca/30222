package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Crocodile extends Reptile{

	private int length; 
	
	public Crocodile(){
		super(5, 0.3);
		this.setNrOfLegs(4);
		this.setName("Crocodile");
		this.setLaysEggs(true);
		this.setLength(5);
	}
	
	
	public Crocodile(int length, boolean laysEggs){
		super(5, 0.3);
		setNrOfLegs(4);
		setName("Crocodile");
		this.setLength(length);
		this.laysEggs = laysEggs;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.CROCODILE);
	}
	
	public void decodeFromXml(Element element) {  
		setLength(Integer.valueOf(element.getElementsByTagName("length").item(0).getTextContent()));  	
 	} 
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
