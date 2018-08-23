package utils;

import java.util.List;

import implementations.Animal;

public class PrinterHelper {

	private static final int ZERO = 0;
	private static final String MOVING = " is moving";
	private static final String NOT_MOVING = " is not moving";
	private static final String EMPTY_STRING = "";
	private static final String COMMA_AND_SPACE = ", ";

	public void print(String input) {
		System.out.println(input);
	}

	public void printAnimalArray(Animal[] animals) {
		if (animals != null && animals.length != ZERO) {
			for (Animal animal : animals) {
				if (animal != null) {
					String animalName = animal.getName();
					print(animalName);
					if (animal.isMoving()) {
						print(animalName + MOVING);
					} else {
						print(animalName + NOT_MOVING);
					}
				}
			}
		}
	}

	public void printAvailableAnimalSlots(List<Integer> availableAnimalSlots) {
		if (availableAnimalSlots != null && !availableAnimalSlots.isEmpty()) {
			String toPrint = EMPTY_STRING;
			int sizeOfAvailableAnimalSlots = availableAnimalSlots.size();
			for (int index = 0; index < sizeOfAvailableAnimalSlots; index++) {
				String currentAnimalSlot = availableAnimalSlots.get(index).toString();
				toPrint = toPrint.concat(currentAnimalSlot);
				toPrint = toPrint.concat(COMMA_AND_SPACE);
			}
			if (!toPrint.isEmpty() ) {
				int toPrintSize = toPrint.length();
				toPrint = toPrint.substring(ZERO, toPrintSize-2);
			}
			print(toPrint);
		}
	}
}
