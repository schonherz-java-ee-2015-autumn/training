package hu.schonherz.training.java.solid.validator.rule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;
import hu.schonherz.training.java.solid.validator.rule.ValidationRule;

@RunWith(MockitoJUnitRunner.class)
public class RuleValidatorTest {

  private static final String CONTEXT1 = "context1";
  private static final String CONTEXT2 = "context2";
  private static final String CONTEXT3 = "context3";
  private static final String ERROR1 = "error1";
  private static final String ERROR2 = "error2";
  private static final String ERROR3 = "error3";

  @Mock
  private ValidationRule<Object> rule1;

  @Mock
  private ValidationRule<Object> rule2;

  private RuleValidator<Object> sut;

  @Before
  public void setUp() throws Exception {
    this.sut = new RuleValidator<>(Arrays.asList(this.rule1, this.rule2));
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenRulesCollectionIsNull() {
    new RuleValidator<Object>(null);

    fail("Constructor should have thrown a NullPointerException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowNPEWhenRulesCollectionHasNullElement() {
    new RuleValidator<Object>(Arrays.asList(null, this.rule1, this.rule2));

    fail("Constructor should have thrown a IllegalArgumentException");
  }

  @Test(expected = NullPointerException.class)
  public void testValidateShouldThrowNPEWhenObjectIsNull() throws Exception {
    this.sut.validate(null);

    fail("Validate should have thrown a NullPointerException");
  }

  @Test
  public void testValidateShouldThrowValidationExceptionWhenFirstRuleFails() throws Exception {
    Object object = new Object();
    Violation violation1 = new Violation(CONTEXT1, ERROR1);
    doReturn(Arrays.asList(violation1)).when(this.rule1).validate(object);
    doReturn(Collections.emptyList()).when(this.rule2).validate(object);

    try {
      this.sut.validate(object);
      fail("Validate should have thrown a ViolationException");
    } catch (ViolationException e) {
      assertViolations(e, violation1);
    }
  }

  @Test
  public void testValidateShouldThrowValidationExceptionWhenSecondRuleFails() throws Exception {
    Object object = new Object();
    Violation violation2 = new Violation(CONTEXT2, ERROR2);
    doReturn(Collections.emptyList()).when(this.rule1).validate(object);
    doReturn(Arrays.asList(violation2)).when(this.rule2).validate(object);

    try {
      this.sut.validate(object);
      fail("Validate should have thrown a ViolationException");
    } catch (ViolationException e) {
      assertViolations(e, violation2);
    }
  }

  @Test
  public void testValidateShouldThrowValidationExceptionWhenAllRulesFail() throws Exception {
    Object object = new Object();
    Violation violation1 = new Violation(CONTEXT1, ERROR1);
    Violation violation2 = new Violation(CONTEXT2, ERROR2);
    doReturn(Arrays.asList(violation1)).when(this.rule1).validate(object);
    doReturn(Arrays.asList(violation2)).when(this.rule2).validate(object);

    try {
      this.sut.validate(object);
      fail("Validate should have thrown a ViolationException");
    } catch (ViolationException e) {
      assertViolations(e, violation1, violation2);
    }
  }

  @Test
  public void testValidateShouldThrowValidationExceptionWhenSomeRulesFail() throws Exception {
    this.sut = new RuleValidator<>(Arrays.asList(this.rule1, this.rule1, this.rule1, this.rule2));

    Object object = new Object();
    Violation violation1 = new Violation(CONTEXT1, ERROR1);
    Violation violation2 = new Violation(CONTEXT2, ERROR2);
    Violation violation3 = new Violation(CONTEXT3, ERROR3);
    doReturn(Arrays.asList(violation1)).doReturn(Arrays.asList(violation3))
        .doReturn(Collections.emptyList()).when(this.rule1).validate(object);
    doReturn(Arrays.asList(violation2)).when(this.rule2).validate(object);

    try {
      this.sut.validate(object);
      fail("Validate should have thrown a ViolationException");
    } catch (ViolationException e) {
      assertViolations(e, violation1, violation3, violation2);
    }
  }

  @Test
  public void testValidateShouldThrowValidationExceptionWhenSingleRuleFailsWithMultipleViolations()
      throws Exception {
    Object object = new Object();
    Violation violation1 = new Violation(CONTEXT1, ERROR1);
    Violation violation2 = new Violation(CONTEXT2, ERROR2);
    Violation violation3 = new Violation(CONTEXT3, ERROR3);
    doReturn(Arrays.asList(violation1, violation2, violation3)).when(this.rule1).validate(object);
    doReturn(Collections.emptyList()).when(this.rule2).validate(object);

    try {
      this.sut.validate(object);
      fail("Validate should have thrown a ViolationException");
    } catch (ViolationException e) {
      assertViolations(e, violation1, violation2, violation3);
    }
  }

  @Test
  public void testValidateShouldAcceptObjectWhenNoRulesHaveViolation() throws Exception {
    Object object = new Object();
    doReturn(Collections.emptyList()).when(this.rule1).validate(object);
    doReturn(Collections.emptyList()).when(this.rule2).validate(object);

    this.sut.validate(object);
  }

  private void assertViolations(ViolationException e, Violation... expectedViolations) {
    assertNotNull(e);
    assertNotNull(e.getViolations());
    assertEquals(expectedViolations.length, e.getViolations().size());

    for (Violation expected : expectedViolations) {
      assertTrue(e.getViolations().contains(expected));
    }
  }

}
