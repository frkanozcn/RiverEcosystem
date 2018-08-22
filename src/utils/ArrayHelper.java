package utils;

import interfaces.IAnimal;
import utils.PrinterHelper;

public class ArrayHelper {
	// integers
	private static final int ZERO = 0;
	// strings
	private static final String ARRAY_IS_NULL = "Array is null";
	private static final String NO_ENTRY = "No life in the river";
	private static final String OUT_OF_INDEX = "Index is not in the range";
	
	public void deleteFromArray (IAnimal[] animals, int index) {
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
	}
	
	private void print(String toBePrinted) {
		PrinterHelper printerHelper = new PrinterHelper();
		printerHelper.print(toBePrinted);
	}

}
