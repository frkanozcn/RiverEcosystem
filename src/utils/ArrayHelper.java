package utils;

import java.util.ArrayList;
import java.util.List;

import implementations.Animal;
import implementations.Bear;
import implementations.Fish;
import utils.PrinterHelper;

public class ArrayHelper {
	// integers
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int INVALID_INDEX = -1;
	// strings
	private static final String ARRAY_IS_NULL = "Array is null";
	private static final String NO_ENTRY = "No life in the river";
	private static final String OUT_OF_INDEX = "Index is not in the range";
	private static final String GENERATION_DONE = "Animal array is generated.";
	private static final String ANIMAL = "animal";
	private static final String INVALID_NEXT_INDEX = "Next index is invalid";

	public Animal[] deleteFromArray(Animal[] animals, int index) {
		int numberOfAnimals = ZERO;
		if (animals == null) {
			print(ARRAY_IS_NULL);
			return animals;
		}
		numberOfAnimals = animals.length;
		if (numberOfAnimals == ZERO) {
			print(NO_ENTRY);
			return animals;
		}
		if (index >= numberOfAnimals) {
			print(OUT_OF_INDEX);
			return animals;
		}
		Animal[] animalTemp = new Animal[numberOfAnimals - 1];
		for (int currentIndex = 0; currentIndex < numberOfAnimals; currentIndex++) {
			if (currentIndex != index) {
				animalTemp[currentIndex] = animals[currentIndex];
			} else {
				animalTemp[currentIndex] = new Animal();
				print("Element with the index of " + currentIndex + " is deleted.");
			}
		}
		return animalTemp;
	}

	public Animal[] generateAnimalArray(int numberOfAnimals) {
		Animal[] animalArray = new Animal[numberOfAnimals];
		print("Generating array of size " + numberOfAnimals + "...");
		for (int currentIndex = 0; currentIndex < numberOfAnimals; currentIndex++) {
			double decider = Math.random();
			decider = decider * 3;
			int deciderInt = (int) decider;
			print("Current index: " + currentIndex + " Decider: " + deciderInt);
			animalArray[currentIndex] = decideAnimalType(deciderInt);
		}
		print(GENERATION_DONE);
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

	public void decideToMove(Animal[] animals) {
		for (int index = 0; index < animals.length; index++) {
			double decideToMove = Math.random();
			decideToMove = decideToMove * 2;
			int decideToMoveInt = (int) decideToMove;
			Animal currentAnimal = animals[index];
			if (!isAnimalValid(currentAnimal)) {
				continue;
			}
			if (decideToMoveInt == ONE) {
				currentAnimal.setMoving(true);
			} else {
				currentAnimal.setMoving(false);
			}
			animals[index] = currentAnimal;
		}
	}

	private boolean isAnimalValid(Animal animal) {
		return (animal instanceof Bear || animal instanceof Fish);
	}

	public List<Integer> availableAnimalSlots(Animal[] animals) {
		List<Integer> availableAnimalSlots = new ArrayList<Integer>();
		for (int index = 0; index < animals.length; index++) {
			Animal currentAnimal = animals[index];
			if (currentAnimal != null && currentAnimal.getName() != null
					&& currentAnimal.getName().equalsIgnoreCase(ANIMAL)) {
				availableAnimalSlots.add(index);
			}
		}
		return availableAnimalSlots;
	}

	public int nextIndex(int index, Animal[] animals) {
		if (animals != null && animals.length > 0) {
			return (index + 1) % animals.length;
		} else {
			print(INVALID_NEXT_INDEX);
			return INVALID_INDEX;
		}
	}

	public void dealWithCollision(int index, Animal[] animals) {

	}

	public void moveWithoutCollision(int index, Animal[] animals) {

	}

	public void doNotMove(int index, Animal[] animals) {

	}

	private void print(String toBePrinted) {
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.print(toBePrinted);
	}

}
