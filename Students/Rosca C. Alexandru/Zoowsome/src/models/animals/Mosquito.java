package models.animals;
import static repositories.AnimalRepository.createNode;

import javax.xml.stream.*;

import org.w3c.dom.Element;

import services.factories.Constants; 


public class Mosquito extends Insect{

	private boolean canCarryVirus;
	
	
	public Mosquito(){
		super(0.1, 0.1);
		this.setNrOfLegs(10);
		this.setName("Mosquito");
		this.setDangerous(true);
		this.setCanFly(true);
		setCanCarryVirus(false);
	}
	
	
	public Mosquito(boolean canCarryVirus, boolean canFly, boolean isDangerous){
		super(0.1, 0.1);
		setNrOfLegs(8);
		setName("Mosquito");
		this.setCanCarryVirus(canCarryVirus);
		this.isDangerous = isDangerous;
		this.canFly = canFly;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.MOSQUITO);
	}
	
	public void decodeFromXml(Element element) {  
		setCanCarryVirus(Boolean.valueOf(element.getElementsByTagName("canCarryVirus").item(0).getTextContent()));  	
 	} 
	
	public boolean isCanCarryVirus() {
		return canCarryVirus;
	}

	public void setCanCarryVirus(boolean canCarryVirus) {
		this.canCarryVirus = canCarryVirus;
	}
}
