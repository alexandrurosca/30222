package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Horse extends Mammal{

	private boolean isRaceHorse;
	
	public Horse(){
		super(3, 0.1);
		this.setNrOfLegs(4);
		this.setName("Horse");
		this.setNormalBodytemp(37);
		this.setPercBodyHair(92); 
		this.setRaceHorse(true);
	}
	
	public Horse(boolean isRaceHorse, float normalBodytemp, float percBodyHair){
		super(3, 0.1);
		setNrOfLegs(4);
		setName("Horse");
		this.setRaceHorse(isRaceHorse);
		this.normalBodytemp = normalBodytemp;
		this.percBodyHair = percBodyHair;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.HORSE);
	}
	
	public void decodeFromXml(Element element) {  
		setRaceHorse(Boolean.valueOf(element.getElementsByTagName("isRaceHorse").item(0).getTextContent()));  	
 	}
	
	public boolean isRaceHorse() {
		return isRaceHorse;
	}
	public void setRaceHorse(boolean isRaceHorse) {
		this.isRaceHorse = isRaceHorse;
	}
	
}
