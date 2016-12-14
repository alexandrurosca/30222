package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Frog extends Aquatic{

	private boolean isPoisonous;
	
	public Frog(){
		super(2 , 0.1);
		this.setNrOfLegs(4);
		this.setName("Frog");
		this.setAvgSwimDepth(1);
		setPoisonous(false);
	}
	
	
	public Frog(boolean isPoisonous, int avgSwimDepth ){
		super(2 , 0.1);
		setNrOfLegs(4);
		setName("Frog");
		this.setPoisonous(isPoisonous);
		this.avgSwimDepth = avgSwimDepth;
	}
	
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.FROG);
	}
	
	public void decodeFromXml(Element element) {  
		setPoisonous(Boolean.valueOf(element.getElementsByTagName("isPoisonous").item(0).getTextContent()));  	
 	}
	
	public boolean isPoisonous() {
		return isPoisonous;
	}

	public void setPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
}
