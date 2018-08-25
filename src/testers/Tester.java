package testers;

import java.util.List;

import implementations.Animal;

import utils.ArrayHelper;
import utils.PrinterHelper;

public class Tester {

	// integers
	private static final int NUMBER_OF_ANIMALS = 100;
	private static final int NUMBER_OF_ITERATIONS = 11; // 11 is critical for fishes
	// strings
	private static final String ITERATION_STARTED = "Iteration started...";
	// booleans
	private static final boolean FALSE = false;
	private static final boolean TRUE = true;

	public static void main(String[] args) {
		// helper classes
		ArrayHelper arrayHelper = new ArrayHelper();
		PrinterHelper printerHelper = new PrinterHelper();
		// declarations
		Animal[] animals = arrayHelper.generateAnimalArray(NUMBER_OF_ANIMALS);
		// iteration started
		printerHelper.print(ITERATION_STARTED);
		Long startTime = System.currentTimeMillis();
		for (int iteration = 0; iteration < NUMBER_OF_ITERATIONS; iteration++) {
			int iterationToString = iteration + 1;
			printerHelper.print("Iteration: " + iterationToString);
			simulateIteration(arrayHelper, printerHelper, animals);
		}
		Long endTime = System.currentTimeMillis();
		Long timeElapsed = endTime - startTime;
		printerHelper.print(timeElapsed.toString());
	}

	private static void simulateIteration(ArrayHelper arrayHelper, PrinterHelper printerHelper, Animal[] animals) {
		List<Integer> availableAnimalSlots = arrayHelper.availableAnimalSlots(animals);
		printerHelper.printAvailableAnimalSlots(availableAnimalSlots);
		for (int index = 0; index < NUMBER_OF_ANIMALS; index++) {
			printerHelper.print("Current index: " + index);
			animals = arrayHelper.decideToMove(animals, index);
			boolean isCurrentAnimalMoving = animals[index].isMoving();
			if (isCurrentAnimalMoving) {
				animals = arrayHelper.dealWithCollision(index, animals);
			}
			printerHelper.printAnimalArray(animals);
			availableAnimalSlots = arrayHelper.availableAnimalSlots(animals);
			printerHelper.printAvailableAnimalSlots(availableAnimalSlots);
			int numberOfBears = arrayHelper.numberOfBears(animals);
			int numberOfFishes = arrayHelper.numberOfFishes(animals);
			printerHelper.print("Number of bears: " + numberOfBears);
			printerHelper.print("Number of fishes: " + numberOfFishes);
			printerHelper.print("-----");
		}
	}

}
