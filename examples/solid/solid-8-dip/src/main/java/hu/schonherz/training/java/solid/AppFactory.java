package hu.schonherz.training.java.solid;

import java.io.File;
import java.util.Arrays;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.impl.AccountServiceImpl;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.account.validation.EmailFormatRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryEmailRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordConfirmationRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryUsernameRule;
import hu.schonherz.training.java.solid.account.validation.PasswordAndConfirmationAreEqualRule;
import hu.schonherz.training.java.solid.account.validation.PasswordFormatRule;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.impl.CipherServiceImpl;
import hu.schonherz.training.java.solid.converter.Converter;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.impl.AccountDAOImpl;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

public class AppFactory {

  private static final String KEY = "+d/Hd+CIMj/ochQmEcLGTg==";
  private static final String IV = "WVyENBxRsmHQyYJWWahmfg==";
  private static final String DB = System.getProperty("user.dir") + File.separator + "accounts.csv";

  private AccountService accountService;
  private Converter<AccountRegistrationRequest, Account> converter;
  private CipherService cipherService;
  private AccountDAO accountDAO;
  private Validator<AccountRegistrationRequest> validator;

  public AppFactory() {
    this.cipherService = new CipherServiceImpl(KEY, IV);
    this.converter =
        new AccountRegistrationRequestToAccountConverter(this.cipherService);

    this.accountDAO = new AccountDAOImpl(DB);
    this.validator =
        new RuleValidator<>(Arrays.asList(new MandatoryEmailRule(), new MandatoryUsernameRule(),
            new MandatoryPasswordRule(), new MandatoryPasswordConfirmationRule(),
            new PasswordAndConfirmationAreEqualRule(), new EmailFormatRule(), new PasswordFormatRule()));

    this.accountService =
        new AccountServiceImpl(this.accountDAO, this.validator, this.converter);
  }

  public AccountService getAccountService() {
    return accountService;
  }

  public Converter<AccountRegistrationRequest, Account> getAccountRegistrationRequestToAccountConverter() {
    return converter;
  }

  public Validator<AccountRegistrationRequest> getValidator() {
    return validator;
  }

  public CipherService getCipherService() {
    return cipherService;
  }

  public AccountDAO getAccountDAO() {
    return accountDAO;
  }
}
