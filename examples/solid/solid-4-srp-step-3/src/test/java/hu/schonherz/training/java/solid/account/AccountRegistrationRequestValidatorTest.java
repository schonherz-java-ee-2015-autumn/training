package hu.schonherz.training.java.solid.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequestValidator;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class AccountRegistrationRequestValidatorTest {

  private AccountRegistrationRequestValidator sut;
  private AccountRegistrationRequest request;

  @Before
  public void setUp() throws Exception {
    this.sut = new AccountRegistrationRequestValidator();
    this.request = new AccountRegistrationRequest();

    this.request.setUsername("username");
    this.request.setEmail("email@address.com");
    this.request.setPassword("password");
    this.request.setPasswordConfirmation("password");
  }

  @Test(expected = NullPointerException.class)
  public void testValidateShouldThrowNPEWhenRequestIsNull() throws Exception {
    this.sut.validate(null);

    fail("Validate should have thrown NullPointerException");
  }

  @Test
  public void testValidateShouldAcceptValidRequest() throws Exception {
    this.sut.validate(this.request);
  }

  @Test
  public void testValidateShouldRejectNullUsername() throws Exception {
    this.request.setUsername(null);

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("username", "Username must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectEmptyUsername() throws Exception {
    this.request.setUsername("");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("username", "Username must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectBlankUsername() throws Exception {
    this.request.setUsername(" \n\t");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("username", "Username must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectNullEmail() throws Exception {
    this.request.setEmail(null);

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("email", "Email address must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectEmptyEmail() throws Exception {
    this.request.setEmail("");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("email", "Email address must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectBlankEmail() throws Exception {
    this.request.setEmail(" \n\t");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("email", "Email address must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectInvalidEmail() throws Exception {
    this.request.setEmail("invalid email");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("email", "A valid email address must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectNullPassword() throws Exception {
    this.request.setPassword(null);

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("password", "Password must be entered"));
    }
  }

  @Test
  public void testValidateShouldRejectEmptyPassword() throws Exception {
    this.request.setPassword("");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("password", "Password must be entered"), new Violation(
          "passwordConfirmation", "Password confirmation must match the password entered"));
    }
  }

  @Test
  public void testValidateShouldRejectBlankPassword() throws Exception {
    this.request.setPassword(" \n\t");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("password", "Password must be entered"), new Violation(
          "passwordConfirmation", "Password confirmation must match the password entered"));
    }
  }

  @Test
  public void testValidateShouldRejectNullPasswordConfirmation() throws Exception {
    this.request.setPasswordConfirmation(null);

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("passwordConfirmation",
          "Password confirmation must be entered"), new Violation("passwordConfirmation",
          "Password confirmation must match the password entered"));
    }
  }

  @Test
  public void testValidateShouldRejectEmptyPasswordConfirmation() throws Exception {
    this.request.setPasswordConfirmation("");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("passwordConfirmation",
          "Password confirmation must be entered"), new Violation("passwordConfirmation",
          "Password confirmation must match the password entered"));
    }
  }

  @Test
  public void testValidateShouldRejectBlankPasswordConfirmation() throws Exception {
    this.request.setPasswordConfirmation(" \n\t");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("passwordConfirmation",
          "Password confirmation must be entered"), new Violation("passwordConfirmation",
          "Password confirmation must match the password entered"));
    }
  }

  @Test
  public void testValidateShouldRejectNotMatchingPasswords() throws Exception {
    this.request.setPasswordConfirmation("not the same as password");

    try {
      this.sut.validate(this.request);
    } catch (ViolationException e) {
      assertViolations(e, new Violation("passwordConfirmation",
          "Password confirmation must match the password entered"));
    }
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
