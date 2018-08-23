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
	// booleans
	private static final boolean FALSE = false;
	private static final boolean TRUE = true;

	public static void main(String[] args) {
		// helper classes
		ArrayHelper arrayHelper = new ArrayHelper();
		PrinterHelper printerHelper = new PrinterHelper();
		// declerations
		Animal[] animals = arrayHelper.generateAnimalArray(NUMBER_OF_ANIMALS);
		List<Integer> availableAnimalSlots = arrayHelper.availableAnimalSlots(animals);
		boolean isCollisionCase = FALSE;
		// iteration started
		printerHelper.print(ITERATION_STARTED);
		for (int iteration = 0; iteration < NUMBER_OF_ITERATIONS; iteration++) {
			int iterationToString = iteration + 1;
			printerHelper.print("Iteration: " + iterationToString);
		}
		// test area: for 1 iteration
		arrayHelper.decideToMove(animals);
		printerHelper.printAnimalArray(animals);
		printerHelper.printAvailableAnimalSlots(availableAnimalSlots);
		for (int index = 0; index < animals.length; index++) {
			int nextIndex = arrayHelper.nextIndex(index, animals);
			boolean isCurrentAnimalMoving = animals[index].isMoving();
			boolean isNextAnimalMoving = animals[nextIndex].isMoving();
			isCollisionCase = isCurrentAnimalMoving && !isNextAnimalMoving;
			if (isCollisionCase) { // currentAnimal will collide with the next animal
				arrayHelper.dealWithCollision(index, animals);
			} else if (isCurrentAnimalMoving) { // next animal will move to index + 2 and current animal will move to
												// index + 1
				arrayHelper.moveWithoutCollision(index, animals);
			} else {
				arrayHelper.doNotMove(index, animals); // do not matter if the next animal moves or not
			}
			// array manipulation will be hard
			// try to put currentIndex variable in Animal class
			// think about declaring move functions in IAnimal
		}
		// think about declaring move functions in IAnimal
	}

}
