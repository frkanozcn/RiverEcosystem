package implementations;

import interfaces.IAnimal;

public class Animal implements IAnimal {

	private static final String DEFAULT_NAME = "animal";

	private String name;

	public Animal() {
		setName(DEFAULT_NAME);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
