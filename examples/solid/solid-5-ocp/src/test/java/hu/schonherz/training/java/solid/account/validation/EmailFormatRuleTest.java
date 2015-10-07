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
import hu.schonherz.training.java.solid.account.validation.EmailFormatRule;
import hu.schonherz.training.java.solid.validator.Violation;

@RunWith(Theories.class)
public class EmailFormatRuleTest {

  private static final Violation VIOLATION = new Violation("email",
      "A valid email address must be entered");

  private EmailFormatRule sut;
  private AccountRegistrationRequest request;

  @DataPoints("accept")
  public static final String[] emailsToAccept = {null, "", " \n\t", "email@mailer.com", "another.mail@provider.co.uk"};

  @DataPoints("reject")
  public static final String[] emailsToReject = {"email", "email.com", "email?@mailer.com"};

  @Before
  public void setUp() throws Exception {
    this.sut = new EmailFormatRule();
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
      public String getPassword() {
        throw new NotImplementedException("Getting password is not implemented");
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
  public void testValidateShouldRejectValue(@FromDataPoints("reject") String email)
      throws Exception {
    this.request.setEmail(email);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertTrue(result.contains(VIOLATION));
  }

  @Theory
  public void testValidateShouldAcceptValue(@FromDataPoints("accept") String email)
      throws Exception {
    this.request.setEmail(email);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }
}
