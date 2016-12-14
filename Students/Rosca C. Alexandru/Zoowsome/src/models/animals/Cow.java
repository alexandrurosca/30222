package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Cow extends Mammal{

	private float litersOfMilk;
	
	public Cow(){
		super(4,0.01);
		this.setNrOfLegs(4);
		setName("Cow");
		this.setNormalBodytemp(35);
		this.setPercBodyHair(90);
		setLitersOfMilk(2);
	}
	
	
	public Cow(float litersOfMilk, float normalBodytemp, float percBodyHair){
		super(4,0.01);
		setNrOfLegs(4);
		setName("Cow");
		this.setLitersOfMilk(litersOfMilk);
		this.normalBodytemp = normalBodytemp;
		this.percBodyHair = percBodyHair;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.COW);
	}
	
	public void decodeFromXml(Element element) {  
		setLitersOfMilk(Integer.valueOf(element.getElementsByTagName("litersOfMilk").item(0).getTextContent()));  	
 	} 
	
	public float getLitersOfMilk() {
		return litersOfMilk;
	}

	public void setLitersOfMilk(float litersOfMilk) {
		this.litersOfMilk = litersOfMilk;
	}
}
