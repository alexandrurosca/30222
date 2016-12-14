package repositories;

import java.io.*;
import java.util.ArrayList;
import javax.lang.model.element.Element;
import javax.xml.parsers.*;
import javax.xml.soap.Node;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import javax.xml.stream.XMLEventFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import interfaces.XML_Parsable;
import models.animals.*;
import services.factories.Constants;

public class AnimalRepository extends EntityRepository<Animal>{
	
	public static final String XML_FILENAME = "Animals.xml";
	private org.w3c.dom.Document doc;
	
	public AnimalRepository(){
		super(XML_FILENAME, Constants.XML_TAGS.ANIMAL);
	};
	
	protected Animal getEntityFromXmlElement(Element element){
		String discriminant = ((Document) element).getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
		
		switch(discriminant){
			case Constants.Animals.Insects.ANT:
				Animal ant  = new Ant();
				ant.decodeFromXml(element);
				return ant;
			
			case Constants.Animals.Insects.MOSQUITO:  	 	 	 	 	
	 	 		Animal mosquito = new Mosquito();  	 	 	 	 
	 	 		mosquito.decodeFromXml(element);  	 	 	 	 	
	 	 		return mosquito;
	 	 		
	 	 		
	 	 	case Constants.Animals.Insects.FLY:  	 	 	 	 	
	 	 		Animal fly = new Fly();  	 	 	 	 
	 	 		fly.decodeFromXml(element);  	 	 	 	 	
	 	 		return fly;
	 	 		
	 	 	case Constants.Animals.Mammals.LION:  	 	 	 	 	
	 	 		Animal lion = new Lion();  	 	 	 	 
	 	 		lion.decodeFromXml(element);  	 	 	 	 	
	 	 		return lion;
	 	 		
	 	 	case Constants.Animals.Mammals.COW:  	 	 	 	 	
	 	 		Animal cow = new Cow();  	 	 	 	 
	 	 		cow.decodeFromXml(element);  	 	 	 	 	
	 	 		return cow;
	 	 		
	 	 	case Constants.Animals.Mammals.HORSE:  	 	 	 	 	
	 	 		Animal horse = new Horse();  	 	 	 	 
	 	 		horse.decodeFromXml(element);  	 	 	 	 	
	 	 		return horse;
	 	 		
	 	 	case Constants.Animals.Birds.CROW:  	 	 	 	 	
	 	 		Animal crow = new Crow();  	 	 	 	 
	 	 		crow.decodeFromXml(element);  	 	 	 	 	
	 	 		return crow;
	 	 		
	 	 	case Constants.Animals.Birds.EAGLE:  	 	 	 	 	
	 	 		Animal eagle = new Eagle();  	 	 	 	 
	 	 		eagle.decodeFromXml(element);  	 	 	 	 	
	 	 		return eagle;
	 	 		
	 	 	case Constants.Animals.Birds.WOODPECKR:  	 	 	 	 	
	 	 		Animal woodpecker = new Woodpecker();  	 	 	 	 
	 	 		woodpecker.decodeFromXml(element);  	 	 	 	 	
	 	 		return woodpecker;
	 	 		
	 	 	case Constants.Animals.Aquatics.FROG:  	 	 	 	 	
	 	 		Animal frog = new Frog();  	 	 	 	 
	 	 		frog.decodeFromXml(element);  	 	 	 	 	
	 	 		return frog;
	 	 		
	 	 	case Constants.Animals.Aquatics.SOMON:  	 	 	 	 	
	 	 		Animal somon = new Somon();  	 	 	 	 
	 	 		somon.decodeFromXml(element);  	 	 	 	 	
	 	 		return somon;
	 	 		
	 	 	case Constants.Animals.Aquatics.TUNA:  	 	 	 	 	
	 	 		Animal tuna = new Tuna();  	 	 	 	 
	 	 		tuna.decodeFromXml(element);  	 	 	 	 	
	 	 		return tuna;
	 	 		
	 	 	case Constants.Animals.Reptiles.CROCODILE:  	 	 	 	 	
	 	 		Animal crocodile = new Crocodile();  	 	 	 	 
	 	 		crocodile.decodeFromXml(element);  	 	 	 	 	
	 	 		return crocodile;
	 	 		
	 	 	case Constants.Animals.Reptiles.LIZZARD:  	 	 	 	 	
	 	 		Animal lizzard = new Lizzard();  	 	 	 	 
	 	 		lizzard.decodeFromXml(element);  	 	 	 	 	
	 	 		return lizzard;
	 	 		
	 	 	case Constants.Animals.Reptiles.SNAKE:  	 	 	 	 	
	 	 		Animal snake = new Snake();  	 	 	 	 
	 	 		snake.decodeFromXml(element);  	 	 	 	 	
	 	 		return snake;
		
		default:
			break;
		}
		return null;
	}
	
	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException { 
 	 	XMLEventFactory eventFactory = XMLEventFactory.newInstance(); 
 	 	XMLEvent end = eventFactory.createDTD("\n"); 
 	 	XMLEvent tab = eventFactory.createDTD("\t"); 
 	 	// Create Start node 
 	 	StartElement sElement = eventFactory.createStartElement("", "", name);
 	 	eventWriter.add(tab);  	 	
 	 	eventWriter.add(sElement); 
 	 	// Create Content 
 	 	Characters characters = eventFactory.createCharacters(value); 
 	 	eventWriter.add(characters); 
 	 	// Create End node 
 	 	EndElement eElement = eventFactory.createEndElement("", "", name); 
 	 	eventWriter.add(eElement); 
 	 	eventWriter.add(end); 
 	} 


	 

	
}
