package services.factories;

public final class Constants {

	public static final int noOfSpecies = 5;
	public static final int noOfAnimalsOfEachType = 3;
	public static final int noOfAnimals = 20;
	public static final long nrOfZero = 1000000000000l;
	public static final int workingHours = 4;
	public static final int nrOfZeroSalary = 1000;
	public static final int nrOfWorkers = 10;
	public static final int startHourDanger = 9;
	public static final int endHourDanger = 22;
	public static final double percDeng = 0.2;
	
	public static final class FRAMES{
		
		public static final int HEIGHT = 500;
		public static final int WIDTH = 700;
	}
	
	

	public static final class XML_TAGS{
		public static final String ANIMAL = "Animal";
		public static final String DISCRIMINANT = "DISCRIMINANT";
	}
	
	public static final class Employees{
		public static final class Caretakers{
			public static final String TCO_SUCCESS = "SUCCESS";
			public static final String TCO_KILLED = "KILLED";
			public static final String TCO_NO_TIME = "NO_TIME";
			public static final String CARETAKER = "Caretaker";
		}
		
		public static final String[] names = {"John", "Mike", "Alex", "Susan", "Troy", "Max", "Lois", "Meg","Peter"};
	}
	
	
	public static final class Species {
		public static final String MAMMALS = "MAMMALS";
		public static final String REPTILES = "REPTILES";
		public static final String BIRDS = "BIRDS";
		public static final String AQUATICS = "AQUATICS";
		public static final String INSECTS = "INSECTS";
	//	public static final int randomWord1 = 5;
	}
	
	public static final class Animals{
		
		public static class Mammals {
			public static final String LION = "LION";
			public static final String COW = "COW";
			public static final String HORSE= "HORSE";
		}
		
		public static class Reptiles {
			public static final String SNAKE = "SNAKE";
			public static final String CROCODILE = "CROCODILE";
			public static final String LIZZARD = "LIZZARD";
		}
		
		public static class Birds {
			public static final String EAGLE = "EAGLE";
			public static final String WOODPECKR = "WOODPECKER";
			public static final String CROW = "CROW";
		}
		
		public static class Aquatics {
			public static final String FROG = "FROG";
			public static final String TUNA = "TUNA";
			public static final String SOMON = "SOMON";
		}
		
		public static class Insects {
			public static final String ANT = "ANT";
			public static final String FLY = "FLY";
			public static final String MOSQUITO = "MOSQUITO";
		}

		//public static int randomWord1 = 15;
	}
}
