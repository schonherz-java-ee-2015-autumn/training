package hu.schonherz.training.java.solid.account;

import java.util.List;

import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.dao.AccountDAO;

public class AccountService {

  private AccountDAO accountDAO;
  private AccountRegistrationRequestValidator validator;
  private AccountRegistrationRequestToAccountConverter converter;

  public AccountService(String keyString, String ivString, String dbFile) {
    this.converter =
        new AccountRegistrationRequestToAccountConverter(new CipherService(keyString, ivString));
    this.accountDAO = new AccountDAO(dbFile);
    this.validator = new AccountRegistrationRequestValidator();
  }

  public AccountRegistrationResponse register(AccountRegistrationRequest request) {
    if (request == null) {
      throw new IllegalArgumentException("Registration request cannot be null");
    }

    List<String> validationErrors = this.validator.validate(request);

    if (validationErrors.size() > 0) {
      return new AccountRegistrationResponse(validationErrors, null);
    }

    Account account = this.converter.convert(request);
    this.accountDAO.save(account);

    return new AccountRegistrationResponse(null, account);
  }

}
