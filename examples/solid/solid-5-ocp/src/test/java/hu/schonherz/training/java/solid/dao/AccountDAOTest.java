package hu.schonherz.training.java.solid.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.common.io.Files;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;

public class AccountDAOTest {

  private static final String INVALID_FILENAME = "this does/not exist";
  private static final String USERNAME = "username";
  private static final String EMAIL = "email";
  private static final String ENCRYPTED_PASSWORD = "encrypted password";
  private static final String EXISTING_CONTENT =
      "other user,email@mailer.com,different encrypted password\n";
  private static final String CONTENT = "username,email,encrypted password\n";
  private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

  private AccountDAO sut;

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  private File dbFile;
  private Account account;

  @Before
  public void setUp() throws Exception {
    this.dbFile = this.tempFolder.newFile();
    this.sut = new AccountDAO(this.dbFile.getAbsolutePath());
    this.account = new Account();
    account.setUsername(USERNAME);
    account.setEmail(EMAIL);
    account.setEncryptedPassword(ENCRYPTED_PASSWORD);
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorShouldThrowNPEWhenDBFileIsNull() {
    new AccountDAO(null);
    fail("Constructor should have thrown a NullPointerException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenDBFileIsEmpty() {
    new AccountDAO("");
    fail("Constructor should have thrown a IllegalArgumentException");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorShouldThrowIllegalArgumentExceptionWhenDBFileIsBlank() {
    new AccountDAO(" \n\t");
    fail("Constructor should have thrown a IllegalArgumentException");
  }

  @Test(expected = DataAccessException.class)
  public void testSaveShouldThrowDataAccessExceptionWhenFileCannotBeWritten() throws Exception {
    this.sut = new AccountDAO(INVALID_FILENAME);

    this.sut.save(account);

    fail("Save should have thrown a DataAccessException");
  }

  @Test
  public void testSaveShouldAppendAccountToEmptyFile() throws Exception {
    this.sut.save(this.account);

    assertTrue(this.dbFile.exists());
    assertEquals(CONTENT, Files.toString(this.dbFile, Charset.forName("UTF-8")));
  }

  @Test
  public void testSaveShouldCreateFileAndSaveAccount() throws Exception {
    this.dbFile.delete();

    this.sut.save(this.account);

    assertTrue(this.dbFile.exists());
    assertEquals(CONTENT, Files.toString(this.dbFile, Charset.forName("UTF-8")));
  }

  @Test
  public void testSaveShouldAppendAccountToNotEmptyFile() throws Exception {
    Files.append(EXISTING_CONTENT, this.dbFile, UTF8_CHARSET);

    this.sut.save(this.account);

    assertTrue(this.dbFile.exists());
    assertEquals(EXISTING_CONTENT + CONTENT, Files.toString(this.dbFile, UTF8_CHARSET));
  }

}
