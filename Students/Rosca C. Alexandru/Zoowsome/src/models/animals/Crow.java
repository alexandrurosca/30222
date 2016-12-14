package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Crow extends Bird{

	private int weight; 
	
	public Crow(){
		super(2,0.01);
		this.setNrOfLegs(4);
		this.setName("Crow");
		this.setAvgFlightAltitude(20);
		this.setMigrate(false);
		setWeight(4);
	}
	
	public Crow(int weight, boolean migrate, int avgFlightAltitude){
		super(2,0.01);
		setName("Crow");
		setNrOfLegs(2);
		this.setWeight(weight);
		this.migrate = migrate;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.CROW);
	}
	
	public void decodeFromXml(Element element) {  
		setWeight(Integer.valueOf(element.getElementsByTagName("weight").item(0).getTextContent()));  	
 	}  
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
