package utils;

import implementations.Animal;
import implementations.Bear;
import implementations.Fish;
import utils.PrinterHelper;

public class ArrayHelper {
	// integers
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	// strings
	private static final String ARRAY_IS_NULL = "Array is null";
	private static final String NO_ENTRY = "No life in the river";
	private static final String OUT_OF_INDEX = "Index is not in the range";

	public void deleteFromArray(Animal[] animals, int index) {
		int numberOfAnimals = ZERO;
		if (animals == null) {
			print(ARRAY_IS_NULL);
			return;
		}
		numberOfAnimals = animals.length;
		if (numberOfAnimals == ZERO) {
			print(NO_ENTRY);
			return;
		}
		if (index >= numberOfAnimals) {
			print(OUT_OF_INDEX);
			return;
		}
		Animal[] animalTemp = new Animal[numberOfAnimals - 1];
		int tempArrayIndexCounter = 0;
		for (int currentIndex = 0; currentIndex < numberOfAnimals; currentIndex++) {
			if (currentIndex != index) {
				animalTemp[tempArrayIndexCounter] = animals[currentIndex];
				print("Current index = " + currentIndex + " set to " + tempArrayIndexCounter);
				tempArrayIndexCounter++;
			}
		}
	}

	public Animal[] generateAnimalArray(int numberOfAnimals) {
		Animal[] animalArray = new Animal[numberOfAnimals];
		for (int currentIndex = 0; currentIndex < numberOfAnimals; currentIndex++) {
			double decider = Math.random();
			decider = decider * 3;
			int deciderInt = (int) decider;
			print("Current index: " + currentIndex + " Decider: " + deciderInt);
			animalArray[currentIndex] = decideAnimalType(deciderInt);
		}
		return animalArray;
	}

	private Animal decideAnimalType(int deciderInt) {
		Animal animal = null;
		switch (deciderInt) {
		case ZERO:
			animal = new Animal();
			break;
		case ONE:
			animal = new Bear();
			break;
		case TWO:
			animal = new Fish();
			break;
		}
		return animal;
	}

	private void print(String toBePrinted) {
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.print(toBePrinted);
	}

}
