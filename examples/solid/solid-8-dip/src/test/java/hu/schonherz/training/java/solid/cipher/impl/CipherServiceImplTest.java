package hu.schonherz.training.java.solid.cipher.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.schonherz.training.java.solid.cipher.EncryptionException;
import hu.schonherz.training.java.solid.cipher.impl.CipherServiceImpl;

public class CipherServiceImplTest {

  private static final String VALID_BASE64_KEY = "+d/Hd+CIMj/ochQmEcLGTg==";
  private static final String VALID_BASE64_IV = "WVyENBxRsmHQyYJWWahmfg==";
  private static final String INVALID_BASE64_KEY = "SW52YWxpZC1rZXkK";
  private static final String INVALID_BASE64_IV = "SW52YWxpZC1pdgo=";
  private static final String INVALID_KEY = "Invalid-key!";
  private static final String INVALID_IV = "Invalid-iv!";
  private static final String UNENCRYPTED = "unencrypted";
  private static final String ENCRYPTED = "Nr5+oTpFhi+SU9zli5SekA==";

  private CipherServiceImpl sut;

  @Before
  public void setUp() throws Exception {
    this.sut = new CipherServiceImpl(VALID_BASE64_KEY, VALID_BASE64_IV);
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenKeyIsNull() {
    new CipherServiceImpl(null, VALID_BASE64_IV);
    fail("Constructor should have thrown NullPointerException");
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenIvIsNull() {
    new CipherServiceImpl(VALID_BASE64_KEY, null);
    fail("Constructor should have thrown NullPointerException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenKeyIsEmpty() {
    new CipherServiceImpl("", VALID_BASE64_IV);
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenIvIsEmpty() {
    new CipherServiceImpl(VALID_BASE64_KEY, "");
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenKeyIsBlank() {
    new CipherServiceImpl(" \n\t", VALID_BASE64_IV);
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenIvIsBlank() {
    new CipherServiceImpl(VALID_BASE64_KEY, " \n\t");
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenKeyIsNotBase64() {
    new CipherServiceImpl(INVALID_KEY, VALID_BASE64_IV);
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenIvIsNotBase64() {
    new CipherServiceImpl(VALID_BASE64_KEY, INVALID_IV);
    fail("Constructor should have thrown IllegalArgumentException");
  }

  @Test(expected = NullPointerException.class)
  public void testEncryptShouldThrowNPEWhenUnencryptedIsNull() throws Exception {
    this.sut.encrypt(null);
    fail("Encrypt should have thrown a NullPointerException");
  }

  @Test(expected = EncryptionException.class)
  public void testEncryptShouldThrowEncryptionExceptionWhenKeyIsInvalid() throws Exception {
    this.sut = new CipherServiceImpl(INVALID_BASE64_KEY, INVALID_BASE64_IV);

    this.sut.encrypt(UNENCRYPTED);

    fail("Encrypt should have thrown EncryptionException");
  }

  @Test
  public void testEncryptShouldEncryptData() throws Exception {
    String result = this.sut.encrypt(UNENCRYPTED);

    assertNotNull(result);
    assertEquals(ENCRYPTED, result);
  }

}
