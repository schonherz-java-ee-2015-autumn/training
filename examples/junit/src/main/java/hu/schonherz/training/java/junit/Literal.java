package hu.schonherz.training.java.junit;

public class Literal implements Expression {

	private int value;
	
	public Literal(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}

}
