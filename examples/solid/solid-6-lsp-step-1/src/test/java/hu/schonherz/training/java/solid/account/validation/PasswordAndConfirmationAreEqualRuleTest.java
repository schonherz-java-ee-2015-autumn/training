package hu.schonherz.training.java.solid.account.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.validation.PasswordAndConfirmationAreEqualRule;
import hu.schonherz.training.java.solid.validator.Violation;

@RunWith(Theories.class)
public class PasswordAndConfirmationAreEqualRuleTest {

  private static final Violation VIOLATION = new Violation("passwordConfirmation",
      "Password confirmation must match the password entered");

  private PasswordAndConfirmationAreEqualRule sut;
  private AccountRegistrationRequest request;

  @DataPoints
  public static final String[] passwordsToReject =
      {null, "", " \n\t", "password", "other password"};

  @Before
  public void setUp() throws Exception {
    this.sut = new PasswordAndConfirmationAreEqualRule();
    this.request = new AccountRegistrationRequest();

    this.request.setUsername("username");
    this.request.setEmail("email@address.com");
    this.request.setPassword("password");
    this.request.setPasswordConfirmation("password");
  }

  @Test
  public void testValidateShouldAcceptValidRequest() throws Exception {
    this.sut.validate(this.request);
  }

  @Test
  public void testValidateShouldIgnoreNotPaswordRelatedFields() throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest() {
      @Override
      public String getEmail() {
        throw new NotImplementedException("Getting email is not implemented");
      }

      @Override
      public String getUsername() {
        throw new NotImplementedException("Getting username is not implemented");
      }
    };

    this.sut.validate(request);
  }

  @Test(expected = NullPointerException.class)
  public void testValidateShouldThrowNPEWhenRequestIsNull() throws Exception {
    this.sut.validate(null);

    fail("Validate should have thrown NullPointerException");
  }

  @Theory
  public void testValidateShouldRejectIfNotEquals(String password, String passwordConfirmation)
      throws Exception {
    Assume.assumeFalse(StringUtils.equals(password, passwordConfirmation));
    this.request.setPassword(password);
    this.request.setPasswordConfirmation(passwordConfirmation);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertTrue(result.contains(VIOLATION));
  }

}
