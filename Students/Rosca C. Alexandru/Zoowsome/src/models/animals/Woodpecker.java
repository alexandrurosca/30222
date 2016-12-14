package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Woodpecker extends Bird{

	private int noOfEggs;
	
	public Woodpecker(){
		super(1, 0.1);
		this.setName("Woodpecker");
		this.setNrOfLegs(2);
		this.setAvgFlightAltitude(20);
		this.setMigrate(true);
		setNoOfEggs(4);
	}
	
	
	public Woodpecker(int noOfEggs, boolean migrate, int avgFlightAltitude){
		super(1, 0.1);
		setName("Woodpecker");
		setNrOfLegs(2);
		this.setNoOfEggs(noOfEggs);
		this.migrate = migrate;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Birds.WOODPECKR);
	}
	
	public void decodeFromXml(Element element) {  
		setNoOfEggs(Integer.valueOf(element.getElementsByTagName("noOfEggs").item(0).getTextContent()));  	
 	}
	
	public int getNoOfEggs() {
		return noOfEggs;
	}

	public void setNoOfEggs(int noOfEggs) {
		this.noOfEggs = noOfEggs;
	}
}
