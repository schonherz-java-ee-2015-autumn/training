package hu.schonherz.training.java.solid;

import java.io.File;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequestValidator;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.dao.AccountDAO;

public class AppFactory {

  private static final String KEY = "+d/Hd+CIMj/ochQmEcLGTg==";
  private static final String IV = "WVyENBxRsmHQyYJWWahmfg==";
  private static final String DB = System.getProperty("user.dir") + File.separator + "accounts.csv";

  private AccountService accountService;
  private AccountRegistrationRequestToAccountConverter accountRegistrationRequestToAccountConverter;
  private AccountRegistrationRequestValidator accountRegistrationRequestValidator;
  private CipherService cipherService;
  private AccountDAO accountDAO;

  public AppFactory() {
    this.cipherService = new CipherService(KEY, IV);
    this.accountRegistrationRequestToAccountConverter =
        new AccountRegistrationRequestToAccountConverter(this.cipherService);

    this.accountDAO = new AccountDAO(DB);
    this.accountRegistrationRequestValidator = new AccountRegistrationRequestValidator();
    this.accountService =
        new AccountService(this.accountDAO, this.accountRegistrationRequestValidator,
            this.accountRegistrationRequestToAccountConverter);
  }

  public AccountService getAccountService() {
    return accountService;
  }

  public AccountRegistrationRequestToAccountConverter getAccountRegistrationRequestToAccountConverter() {
    return accountRegistrationRequestToAccountConverter;
  }

  public AccountRegistrationRequestValidator getAccountRegistrationRequestValidator() {
    return accountRegistrationRequestValidator;
  }

  public CipherService getCipherService() {
    return cipherService;
  }

  public AccountDAO getAccountDAO() {
    return accountDAO;
  }
}
