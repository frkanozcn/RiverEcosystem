package implementations;

import interfaces.IAnimal;

public class Animal implements IAnimal {

	private static final String DEFAULT_NAME = "animal";
	private static final boolean IS_MOVING = false;

	private String name;
	private boolean isMoving;

	public Animal() {
		setName(DEFAULT_NAME);
		setMoving(IS_MOVING);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

}
