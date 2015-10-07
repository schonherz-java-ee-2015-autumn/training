package hu.schonherz.training.java.solid.account.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.validation.PasswordFormatRule;
import hu.schonherz.training.java.solid.validator.Violation;

@RunWith(Theories.class)
public class PasswordFormatRuleTest {

  private static final Violation VIOLATION = new Violation(
      "password",
      "A valid password must be entered, please use lowercase and uppercase letters (a-z, A-Z), digits (0-9) and underscore (_) in your password.");

  private PasswordFormatRule sut;
  private AccountRegistrationRequest request;

  @DataPoints("accept")
  public static final String[] passwordsToAccept = {null, "", " \n\t", "apple", "APPLE", "4ppl3", "4_p_p_l_3", "____"};

  @DataPoints("reject")
  public static final String[] passwordsToReject = {"12-34", "password.with.dot", "is it a password?"};

  @Before
  public void setUp() throws Exception {
    this.sut = new PasswordFormatRule();
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
  public void testValidateShouldIgnoreNotEmailFields() throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest() {
      @Override
      public String getUsername() {
        throw new NotImplementedException("Getting username is not implemented");
      }

      @Override
      public String getEmail() {
        throw new NotImplementedException("Getting email is not implemented");
      }

      @Override
      public String getPasswordConfirmation() {
        throw new NotImplementedException("Getting password confirmation is not implemented");
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
  public void testValidateShouldRejectValue(@FromDataPoints("reject") String password)
      throws Exception {
    this.request.setPassword(password);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertTrue(result.contains(VIOLATION));
  }

  @Theory
  public void testValidateShouldAcceptValue(@FromDataPoints("accept") String password)
      throws Exception {
    this.request.setPassword(password);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }
}
