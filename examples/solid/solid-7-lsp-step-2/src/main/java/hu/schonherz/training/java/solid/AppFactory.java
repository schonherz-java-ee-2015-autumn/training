package hu.schonherz.training.java.solid;

import java.io.File;
import java.util.Arrays;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.validation.EmailFormatRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryEmailRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordConfirmationRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryUsernameRule;
import hu.schonherz.training.java.solid.account.validation.PasswordAndConfirmationAreEqualRule;
import hu.schonherz.training.java.solid.account.validation.PasswordFormatRule;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.validator.RuleValidator;

public class AppFactory {

  private static final String KEY = "+d/Hd+CIMj/ochQmEcLGTg==";
  private static final String IV = "WVyENBxRsmHQyYJWWahmfg==";
  private static final String DB = System.getProperty("user.dir") + File.separator + "accounts.csv";

  private AccountService accountService;
  private AccountRegistrationRequestToAccountConverter accountRegistrationRequestToAccountConverter;
  private CipherService cipherService;
  private AccountDAO accountDAO;
  private RuleValidator<AccountRegistrationRequest> validator;

  public AppFactory() {
    this.cipherService = new CipherService(KEY, IV);
    this.accountRegistrationRequestToAccountConverter =
        new AccountRegistrationRequestToAccountConverter(this.cipherService);

    this.accountDAO = new AccountDAO(DB);
    this.validator =
        new RuleValidator<>(Arrays.asList(new MandatoryEmailRule(), new MandatoryUsernameRule(),
            new MandatoryPasswordRule(), new MandatoryPasswordConfirmationRule(),
            new PasswordAndConfirmationAreEqualRule(), new EmailFormatRule(), new PasswordFormatRule()));

    this.accountService =
        new AccountService(this.accountDAO, this.validator,
            this.accountRegistrationRequestToAccountConverter);
  }

  public AccountService getAccountService() {
    return accountService;
  }

  public AccountRegistrationRequestToAccountConverter getAccountRegistrationRequestToAccountConverter() {
    return accountRegistrationRequestToAccountConverter;
  }

  public RuleValidator<AccountRegistrationRequest> getValidator() {
    return validator;
  }

  public CipherService getCipherService() {
    return cipherService;
  }

  public AccountDAO getAccountDAO() {
    return accountDAO;
  }
}
