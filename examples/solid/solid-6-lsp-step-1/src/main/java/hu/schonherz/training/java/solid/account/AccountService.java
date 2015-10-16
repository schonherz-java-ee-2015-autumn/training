package hu.schonherz.training.java.solid.account;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.dao.AccountDAO;
import hu.schonherz.training.java.solid.dao.DataAccessException;
import hu.schonherz.training.java.solid.validator.RuleValidator;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class AccountService {

  private AccountDAO accountDAO;
  private RuleValidator<AccountRegistrationRequest> validator;
  private AccountRegistrationRequestToAccountConverter converter;

  public AccountService(AccountDAO accountDAO, RuleValidator<AccountRegistrationRequest> validator,
      AccountRegistrationRequestToAccountConverter converter) {
    Validate.notNull(accountDAO);
    Validate.notNull(validator);
    Validate.notNull(converter);

    this.accountDAO = accountDAO;
    this.validator = validator;
    this.converter = converter;
  }

  public Account register(AccountRegistrationRequest request) throws ViolationException,
      AccountRegistrationException {
    try {
      Validate.notNull(request, "Registration request cannot be null");
      this.validator.validate(request);
      Account account = this.converter.convert(request);
      this.accountDAO.save(account);
      return account;
    } catch (DataAccessException | ConversionException e) {
      throw new AccountRegistrationException("Could not register user", e);
    }
  }

}