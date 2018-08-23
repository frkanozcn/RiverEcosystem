package utils;

import implementations.Animal;

public class PrinterHelper {

	private static final int ZERO = 0;

	public void print(String input) {
		System.out.println(input);
	}

	public void printAnimalArray(Animal[] animals) {
		if (animals != null && animals.length != ZERO) {
			for (Animal animal : animals) {
				if (animal != null) {
					print(animal.getName());
				}
			}
		}
	}

}
