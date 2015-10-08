package hu.schonherz.training.java.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {
	
	private static final Literal LITERAL_1 = new Literal(1);
	private static final Literal LITERAL_2 = new Literal(2);

	@Test(expected=NullPointerException.class)
	public void additionConstructorShouldThrowNPEWhenLeftExpressionIsNull() {
		new Addition(null, LITERAL_1);
	}
	
	@Test(expected=NullPointerException.class)
	public void additionConstructorShouldThrowNPEWhenRightExpressionIsNull() {
		new Addition(LITERAL_1, null);
	}
	
	@Test
	public void getValueShouldReturnTheSumOfLeftAndRightExpression() {
		// Given
		final Expression left = LITERAL_1;
		final Expression right = LITERAL_2;
		final int expected = 3;
		final Addition underTest = new Addition(left, right);
		
		// When
		int result = underTest.getValue();
		
		// Then
		assertEquals(expected, result);
	}

}
