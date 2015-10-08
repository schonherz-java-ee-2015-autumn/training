package hu.schonherz.training.java.junit;

public class Variable implements Expression {

	private int value;

	public Variable(int value) {
		this.value = value;
	}
	
	public Variable() {
		this(0);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
