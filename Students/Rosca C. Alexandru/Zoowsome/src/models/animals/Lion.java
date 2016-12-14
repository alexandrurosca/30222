package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Lion extends Mammal{
	
	private float weight;
	
	
	public Lion(){
		super(6, 0.6);
		this.setName("Lion");
		this.setNrOfLegs(4);
		this.setNormalBodytemp(38);
		this.setPercBodyHair(90);
		this.setWeight(70);
	}
	
	
	public Lion(float weight, float normalBodytemp, float percBodyHair){
		super(6, 0.6);
		setName("Lion");
		setNrOfLegs(4);
		this.setWeight(weight);
		this.normalBodytemp = normalBodytemp;
		this.percBodyHair = percBodyHair;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.LION);
	}
	
	public void decodeFromXml(Element element) {  
		setWeight(Float.valueOf(element.getElementsByTagName("weight").item(0).getTextContent()));  	
 	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
