package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Tuna extends Aquatic{

	private float lenght;
	
	public Tuna(){
		super(0.3, 0.1);
		this.setName("Tuna");
		this.setNrOfLegs(0);
		
		this.setAvgSwimDepth(20);
		setLenght(2);
	}
	
	
	public Tuna(float lenght, int avgSwimDepth ){
		super(0.3, 0.1);
		setName("Tuna");
		setNrOfLegs(0);
		this.setLenght(lenght);
		this.avgSwimDepth = avgSwimDepth;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.TUNA);
	}
	
	public void decodeFromXml(Element element) {  
		setLenght(Float.valueOf(element.getElementsByTagName("lenght").item(0).getTextContent()));  	
 	} 
	
	public float getLenght() {
		return lenght;
	}

	public void setLenght(float lenght) {
		this.lenght = lenght;
	}
	
}
