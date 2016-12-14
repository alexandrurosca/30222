package models.animals;

import static repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import services.factories.Constants;

public class Somon extends Aquatic{

	private int migrationDist;
	
	public Somon (){
		super(1, 0);
		this.setName("Somon");
		this.setNrOfLegs(0);
		this.setAvgSwimDepth(6);
	}
	
	
	public Somon(int migrationDist, int avgSwimDepth ){
		super(1, 0);
		setName("Somon");
		setNrOfLegs(0);
		this.setMigrationDist(migrationDist);
		this.avgSwimDepth = avgSwimDepth;
	}

	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatics.SOMON);
	}
	
	public void decodeFromXml(Element element) {  
		setMigrationDist(Integer.valueOf(element.getElementsByTagName("migrationDist").item(0).getTextContent()));  	
 	} 
	
	public int getMigrationDist() {
		return migrationDist;
	}

	public void setMigrationDist(int migrationDist) {
		this.migrationDist = migrationDist;
	}
	
}
