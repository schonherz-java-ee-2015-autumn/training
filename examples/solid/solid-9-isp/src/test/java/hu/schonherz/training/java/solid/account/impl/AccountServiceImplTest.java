package hu.schonherz.training.java.solid.account.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hu.schonherz.training.java.solid.account.AccountRegistrationException;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.impl.AccountServiceImpl;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;
import hu.schonherz.training.java.solid.validator.ViolationException;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

  @Mock
  private AccountDAO accountDAO;

  @Mock
  private RuleValidator<AccountRegistrationRequest> validator;

  @Mock
  private AccountRegistrationRequestToAccountConverter converter;

  private AccountServiceImpl sut;

  @Before
  public void setUp() throws Exception {
    this.sut = new AccountServiceImpl(this.accountDAO, this.validator, this.converter);
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenAccountDAOIsNull() {
    new AccountServiceImpl(null, this.validator, this.converter);
    Assert.fail("Constructor should have thrown a NullPointerException");
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenValidatorIsNull() {
    new AccountServiceImpl(this.accountDAO, null, this.converter);
    Assert.fail("Constructor should have thrown a NullPointerException");
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenConverterIsNull() {
    new AccountServiceImpl(this.accountDAO, this.validator, null);
    Assert.fail("Constructor should have thrown a NullPointerException");
  }

  @Test(expected = NullPointerException.class)
  public void testRegisterShouldThrowNPEWhenRequestIsNull() throws Exception {
    this.sut.register(null);
    fail("Register should have thrown a NullPointerException");
  }

  @Test(expected = ViolationException.class)
  public void testRegisterShouldThrowViolationExceptionWhenValidationFails() throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest();
    doThrow(ViolationException.class).when(this.validator).validate(request);

    this.sut.register(request);

    fail("Register should have thrown a ViolationException");
  }

  @Test(expected = AccountRegistrationException.class)
  public void testRegisterShouldThrowAccountRegistrationExceptionWhenConversionFails()
      throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest();
    doNothing().when(this.validator).validate(request);
    doThrow(ConversionException.class).when(this.converter).convert(request);

    this.sut.register(request);

    fail("Register should have thrown a AccountRegistrationException");
  }

  @Test(expected = AccountRegistrationException.class)
  public void testRegisterShouldThrowAccountRegistrationExceptionWhenPersistenceFails()
      throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest();
    Account account = new Account();
    doNothing().when(this.validator).validate(request);
    doReturn(account).when(this.converter).convert(request);
    doThrow(DataAccessException.class).when(this.accountDAO).save(account);

    this.sut.register(request);

    fail("Register should have thrown a AccountRegistrationException");
  }

  @Test
  public void testRegisterShouldReturnAccount() throws Exception {
    AccountRegistrationRequest request = new AccountRegistrationRequest();
    Account account = new Account();
    doNothing().when(this.validator).validate(request);
    doReturn(account).when(this.converter).convert(request);
    doNothing().when(this.accountDAO).save(account);

    Account result = this.sut.register(request);

    assertNotNull(result);
    assertEquals(result, account);
  }

}
