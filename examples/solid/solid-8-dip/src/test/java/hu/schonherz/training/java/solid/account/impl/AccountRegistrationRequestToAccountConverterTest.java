package hu.schonherz.training.java.solid.account.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.EncryptionException;
import hu.schonherz.training.java.solid.converter.ConversionException;

@RunWith(MockitoJUnitRunner.class)
public class AccountRegistrationRequestToAccountConverterTest {

  private static final String USERNAME = "username";
  private static final String EMAIL = "email";
  private static final String PASSWORD = "password";
  private static final String PASSWORD_CONFIRMATION = "password confirmation";
  private static final String ENCRYPTED_PASSWORD = "encrypted password";

  @Mock
  private CipherService cipherService;

  private AccountRegistrationRequestToAccountConverter sut;

  @Before
  public void setUp() throws Exception {
    this.sut = new AccountRegistrationRequestToAccountConverter(this.cipherService);
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenCipherServiceIsNull() {
    new AccountRegistrationRequestToAccountConverter(null);
    fail("Constructor should have thrown NullPointerException");
  }

  @Test(expected = NullPointerException.class)
  public void testConvertShouldThrowNullPointerExceptionWhenSourceIsNull() throws Exception {
    this.sut.convert(null);
    fail("Convert should have thrown NullPointerException");
  }

  @Test(expected = ConversionException.class)
  public void testConvertShouldThrowConversionExceptionWhenEncryptFails() throws Exception {
    AccountRegistrationRequest source = new AccountRegistrationRequest();
    doThrow(EncryptionException.class).when(this.cipherService).encrypt(anyString());

    this.sut.convert(source);

    fail("Convert should have thrown ConversionException");
  }

  @Test
  public void testConvertShouldConvertSourceToAccount() throws Exception {
    AccountRegistrationRequest source = new AccountRegistrationRequest();
    source.setUsername(USERNAME);
    source.setEmail(EMAIL);
    source.setPassword(PASSWORD);
    source.setPasswordConfirmation(PASSWORD_CONFIRMATION);

    Account account = new Account();
    account.setUsername(USERNAME);
    account.setEmail(EMAIL);
    account.setEncryptedPassword(ENCRYPTED_PASSWORD);

    doReturn(ENCRYPTED_PASSWORD).when(this.cipherService).encrypt(PASSWORD);

    Account result = this.sut.convert(source);

    assertNotNull(result);
    assertEquals(account, result);
  }

}
