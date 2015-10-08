package hu.schonherz.training.java.junit;

public class Addition implements BinaryOperation {
	
	private Expression left;
	private Expression right;
	
	public Addition(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return this.left.getValue() + this.right.getValue();
	}

	public Expression getLeftExpression() {
		return this.left;
	}

	public Expression getRightExpression() {
		return this.right;
	}

}
