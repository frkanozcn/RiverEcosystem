package testers;

import implementations.Animal;

import utils.ArrayHelper;
import utils.PrinterHelper;

public class Tester {

	private static final int NUMBER_OF_ANIMALS = 10;

	public static void main(String[] args) {
		ArrayHelper arrayHelper = new ArrayHelper();
		Animal[] animals = arrayHelper.generateAnimalArray(NUMBER_OF_ANIMALS);
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.printAnimalArray(animals);
	}

}
