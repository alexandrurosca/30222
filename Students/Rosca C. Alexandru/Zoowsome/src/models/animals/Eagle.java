package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Eagle extends Bird{
	
	private float wingSpred;
	
	
	public Eagle (){
		super(4, 0.3);
		this.setNrOfLegs(2);
		this.setName("Eagle");
		this.setMigrate(true);
		this.setAvgFlightAltitude(1000);
		setWingSpred(3);
	}
	
	
	public Eagle(float wingSpred, boolean migrate, int avgFlightAltitude){
		super(4, 0.3);
		setNrOfLegs(2);
		setName("Eagle");
		this.setWingSpred(wingSpred);
		this.migrate = migrate;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.EAGLE);
	}
	
	public void decodeFromXml(Element element) {  
		setWingSpred(Float.valueOf(element.getElementsByTagName("wingSpred").item(0).getTextContent()));  	
 	}
	
	public float getWingSpred() {
		return wingSpred;
	}

	public void setWingSpred(float wingSpred) {
		this.wingSpred = wingSpred;
	}
}
