package testers;

import java.util.List;

import implementations.Animal;

import utils.ArrayHelper;
import utils.PrinterHelper;

public class Tester {

	// integers
	private static final int NUMBER_OF_ANIMALS = 10;
	private static final int NUMBER_OF_ITERATIONS = 1;
	// strings
	private static final String ITERATION_STARTED = "Iteration started...";

	public static void main(String[] args) {
		// helper classes
		ArrayHelper arrayHelper = new ArrayHelper();
		PrinterHelper printerHelper = new PrinterHelper();
		// declerations
		Animal[] animals = arrayHelper.generateAnimalArray(NUMBER_OF_ANIMALS);
		printerHelper.printAnimalArray(animals);
		List<Integer> availableAnimalSlots = arrayHelper.availableAnimalSlots(animals);
		// iteration started
		printerHelper.print(ITERATION_STARTED);
		for (int iteration = 0; iteration < NUMBER_OF_ITERATIONS; iteration++) {
			int iterationToString = iteration + 1;
			printerHelper.print("Iteration: " + iterationToString);
		}
		printerHelper.printAvailableAnimalSlots(availableAnimalSlots);
	}

}
