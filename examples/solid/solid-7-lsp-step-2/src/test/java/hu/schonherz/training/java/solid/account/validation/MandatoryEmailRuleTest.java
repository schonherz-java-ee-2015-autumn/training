package hu.schonherz.training.java.solid.account.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.validation.MandatoryEmailRule;
import hu.schonherz.training.java.solid.validator.Violation;

@RunWith(Theories.class)
public class MandatoryEmailRuleTest {

  private static final Violation VIOLATION =
      new Violation("email", "Email address must be entered");

  private MandatoryEmailRule sut;
  private AccountRegistrationRequest request;

  @DataPoints
  public static final String[] emailsToReject = {null, "", " \n\t"};

  @Before
  public void setUp() throws Exception {
    this.sut = new MandatoryEmailRule();
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
  public void testValidateShouldRejectValue(String email) throws Exception {
    this.request.setEmail(email);

    List<Violation> result = this.sut.validate(this.request);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertTrue(result.contains(VIOLATION));
  }

}
