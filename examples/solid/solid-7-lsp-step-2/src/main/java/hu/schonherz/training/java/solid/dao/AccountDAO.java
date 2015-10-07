package hu.schonherz.training.java.solid.dao;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.model.Account;

public class AccountDAO {
  private String dbFile;

  public AccountDAO(String dbFile) {
    Validate.notBlank(dbFile);
    this.dbFile = dbFile;
  }

  public void save(Account account) throws DataAccessException {
    try (FileWriter writer = new FileWriter(this.dbFile, true)) {
      writer.append(account.getUsername()).append(',').append(account.getEmail()).append(',')
          .append(account.getEncryptedPassword()).append('\n');
    } catch (IOException e) {
      throw new DataAccessException("Unable to save account", e);
    }
  }

}
