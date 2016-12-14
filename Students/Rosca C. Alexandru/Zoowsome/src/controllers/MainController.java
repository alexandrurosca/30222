package controllers;

import models.animals.Animal;
import models.employees.*;
import repositories.AnimalRepository;
import repositories.EntityRepository;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import services.factories.*;

public class MainController {

	public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, SAXException, IOException{
		
		Random random1 = new Random();
		Random random2 = new Random();
		String result = null;
		Animal[] animal = new Animal[Constants.noOfAnimals];
		ArrayList<Animal> animals = new ArrayList<Animal>();
		ArrayList<Animal> animalsLoad = new ArrayList<Animal>();
		AnimalRepository animalRep = new AnimalRepository();
		EntityRepository<Animal> enitityRep = new AnimalRepository();
		
		
		CaretakerFactory caretakerFactory = new CaretakerFactory();
		Employee []caretaker = new Caretaker[Constants.nrOfWorkers];
		for (int i = 0; i < Constants.nrOfWorkers; i++){
				caretaker[i] = caretakerFactory.getEmployee(Constants.Employees.Caretakers.CARETAKER);
		}
		
		
		AnimalFactory abstractFactory = new AnimalFactory();
	
		for( int i = 0; i < Constants.noOfAnimals; i++){
			int speciesType = random1.nextInt(Constants.noOfSpecies ) + 1;
			int animalType  = random2.nextInt(Constants.noOfAnimalsOfEachType ) + 1;
			
			switch (speciesType){
				case 1: 
					SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.MAMMALS); 
					switch(animalType){
						case 1: animal[i] = speciesFactory1.getAnimal(Constants.Animals.Mammals.COW);
						break;
						
						case 2: animal[i] = speciesFactory1.getAnimal(Constants.Animals.Mammals.HORSE);
						break;
						
						case 3: animal[i] = speciesFactory1.getAnimal(Constants.Animals.Mammals.LION);
						break;
						
						default: System.out.println("error");
					}
					break;
				case 2:
					SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory(Constants.Species.REPTILES);
					switch(animalType){
						case 1: animal[i] = speciesFactory2.getAnimal(Constants.Animals.Reptiles.CROCODILE);
						break;
					
						case 2: animal[i] = speciesFactory2.getAnimal(Constants.Animals.Reptiles.LIZZARD);
						break;
					
						case 3: animal[i] = speciesFactory2.getAnimal(Constants.Animals.Reptiles.SNAKE);
						break;
					
						default: System.out.println("error");
				}
					break;
				case 3: 
					SpeciesFactory speciesFactory3 = abstractFactory.getSpeciesFactory(Constants.Species.INSECTS);
					switch(animalType){
						case 1: animal[i] = speciesFactory3.getAnimal(Constants.Animals.Insects.ANT);
						break;
					
						case 2: animal[i] = speciesFactory3.getAnimal(Constants.Animals.Insects.FLY);
						break;
					
						case 3: animal[i] = speciesFactory3.getAnimal(Constants.Animals.Insects.MOSQUITO);
						break;
					
						default: System.out.println("error");
				}
					break;
				case 4: 
					SpeciesFactory speciesFactory4 = abstractFactory.getSpeciesFactory(Constants.Species.AQUATICS);
					switch(animalType){
						case 1: animal[i] = speciesFactory4.getAnimal(Constants.Animals.Aquatics.FROG);
						break;
					
						case 2: animal[i] = speciesFactory4.getAnimal(Constants.Animals.Aquatics.SOMON);
						break;
					
						case 3: animal[i] = speciesFactory4.getAnimal(Constants.Animals.Aquatics.TUNA);
						break;
					
						default: System.out.println("eror");
				}
					break;
				case 5: 
					SpeciesFactory speciesFactory5 = abstractFactory.getSpeciesFactory(Constants.Species.BIRDS);
					switch(animalType){
						case 1: animal[i] = speciesFactory5.getAnimal(Constants.Animals.Birds.CROW);
						break;
				
						case 2: animal[i] = speciesFactory5.getAnimal(Constants.Animals.Birds.EAGLE);
						break;
				
						case 3: animal[i] = speciesFactory5.getAnimal(Constants.Animals.Birds.WOODPECKR);
						break;
				
					default: System.out.println("error");
			}
					break;
				default: System.out.println("error");
			}			
		
	}
		
		for(int i = 0; i < Constants.nrOfWorkers; i++){
			for(int j = 0; j < Constants.noOfAnimals; j++){
				if((caretaker[i].isDead() == false) && (animal[j].isTakenCareOf() == false)){
					result = ((Caretaker) caretaker[i]).takeCareOf(animal[j]);
						if(result.equals(Constants.Employees.Caretakers.TCO_KILLED)){
						caretaker[i].setDead(true);
						break;
						}
						
						else if(result.equals(Constants.Employees.Caretakers.TCO_NO_TIME)){
							continue;
						}
						
						else{
							animal[j].setTakenCareOf(true);
						}
						
								
					}
						
				}
			}
		
		
		for(int i = 0; i < Constants.noOfAnimals; i++){
			animals.add(animal[i]);
		}
		
		animalRep.save(animals);
		try{
			enitityRep.load();
		}
		catch(Exception e){
			System.out.println("Nu s-a putut executa functia load!");
		}
		
		
		
		for(int i = 0; i < Constants.noOfAnimals; i++){
		if(animal[i].isTakenCareOf()){
			System.out.println("Animal " + animal[i].getName() + " has been taken care of \n");
		}
		else{
			System.out.println("Animal " + animal[i].getName() + " hasn't been taken care of \n");
		}
	}
		
	}
		
	
}