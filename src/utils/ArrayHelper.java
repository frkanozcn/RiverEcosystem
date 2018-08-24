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
	private static final String INVALID_NEXT_INDEX = "Next index is invalid";
	private static final String NO_AVAILABLE_SPACE = "No available space for new animal";
	private static final String NO_ONE_TO_MOVE = "No animal found to move";

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

	public Animal[] decideToMove(Animal[] animals, int index) {
		double decideToMove = Math.random();
		decideToMove = decideToMove * 2;
		int decideToMoveInt = (int) decideToMove;
		Animal currentAnimal = animals[index];
		if (isAnimalValid(currentAnimal)) {
			if (decideToMoveInt == ONE) {
				currentAnimal.setMoving(true);
				print(currentAnimal.getName() + " decided to move");
			} else {
				currentAnimal.setMoving(false);
				print(currentAnimal.getName() + " decided to stay");
			}
			animals[index] = currentAnimal;
		} else {
			print(NO_ONE_TO_MOVE);
		}
		return animals;
	}

	private boolean isAnimalValid(Animal animal) {
		return isBear(animal) || isFish(animal);
	}

	public List<Integer> availableAnimalSlots(Animal[] animals) {
		List<Integer> availableAnimalSlots = new ArrayList<Integer>();
		for (int index = 0; index < animals.length; index++) {
			Animal currentAnimal = animals[index];
			if (!isAnimalValid(currentAnimal)) {
				availableAnimalSlots.add(index);
			}
		}
		return availableAnimalSlots;
	}

	public Animal[] dealWithCollision(int index, Animal[] animals) {
		// same type
		int nextIndex = nextIndex(index, animals);
		if (isIndexValid(nextIndex)) {
			Animal currentAnimal = animals[index];
			Animal nextAnimal = animals[nextIndex];
			if (isSameType(currentAnimal, nextAnimal)) { // animals are same
				// allocate an available space
				List<Integer> availableAnimalSlots = availableAnimalSlots(animals);
				int indexOfAllocation = decideAllocation(availableAnimalSlots);
				if (indexOfAllocation != INVALID_INDEX) {
					int emptyAnimalSlot = availableAnimalSlots.get(indexOfAllocation);
					if (isBear(currentAnimal)) {
						animals[emptyAnimalSlot] = new Bear();
						print("New bear allocated to " + emptyAnimalSlot);
					} else {
						animals[emptyAnimalSlot] = new Fish();
						print("New fish allocated to " + emptyAnimalSlot);
					}
				} else {
					print(NO_AVAILABLE_SPACE);
				}
			} else if (!isFish(nextAnimal) && !isBear(nextAnimal)) { // available next slot
				animals[index] = new Animal();
				if (isFish(currentAnimal)) {
					animals[nextIndex] = new Fish();
					print("Fish moves from " + index + " to " + nextIndex);
				} else {
					animals[nextIndex] = new Bear();
					print("Bear moves from " + index + " to " + nextIndex);
				}
			} else { // kill fish
				if (isFish(currentAnimal)) {
					animals[index] = new Animal();
					print("Fish in index " + index + " is killed by bear in index " + nextIndex);
				} else {
					animals[nextIndex] = new Animal();
					print("Fish in index " + nextIndex + " is killed by bear in index " + index);
				}
			}
		} else {
			print(INVALID_NEXT_INDEX);
		}
		return animals;
	}

	private int decideAllocation(List<Integer> availableAnimalSlots) {
		if (availableAnimalSlots != null && !availableAnimalSlots.isEmpty()) {
			int sizeOfAvailableAnimalSlots = availableAnimalSlots.size();
			double decider = Math.random() * sizeOfAvailableAnimalSlots;
			return (int) decider;
		} else {
			return INVALID_INDEX;
		}
	}

	private boolean isSameType(Animal currentAnimal, Animal nextAnimal) {
		boolean areBothBear = isBear(currentAnimal) && isBear(nextAnimal);
		boolean areBothFish = isFish(currentAnimal) && isFish(nextAnimal);
		return areBothBear || areBothFish;
	}

	private boolean isIndexValid(int index) {
		return index != INVALID_INDEX;
	}

	private int nextIndex(int index, Animal[] animals) {
		if (animals != null && animals.length > 0) {
			return (index + 1) % animals.length;
		} else {
			print(INVALID_NEXT_INDEX);
			return INVALID_INDEX;
		}
	}

	private boolean isBear(Animal animal) {
		return animal instanceof Bear;
	}

	private boolean isFish(Animal animal) {
		return animal instanceof Fish;
	}

	private void print(String toBePrinted) {
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.print(toBePrinted);
	}

}
