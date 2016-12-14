package models.animals;

import static repositories.AnimalRepository.createNode;

import java.util.*;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Snake extends Reptile{

	Date time = new Date();
	
	private boolean isPoisonous; 
	
	public Snake(){
		super(3, 0.3);
		this.setName("Snake");
		this.setNrOfLegs(0);
		this.setLaysEggs(true);
		this.setPoisonous(true);
	}

	
	public Snake(boolean isPoisonous, boolean laysEggs){
		super(3, 0.3);
		setName("Snake");
		setNrOfLegs(0);
		this.setPoisonous(isPoisonous);
		this.laysEggs = laysEggs;
		
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptiles.SNAKE);
	}
	
	public void decodeFromXml(Element element) {  
		setPoisonous(Boolean.valueOf(element.getElementsByTagName("isPoisonous").item(0).getTextContent()));  	
 	} 
	
	
	@SuppressWarnings("deprecation")
	public double getPredisposition(){
		if( time.getHours() > Constants.startHourDanger && time.getHours() < Constants.endHourDanger){
			//System.out.println("Danger");
			return Constants.percDeng;
		}
		return 0;
	}

	public boolean isPoisonous() {
		return isPoisonous;
	}

	public void setPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	
}
