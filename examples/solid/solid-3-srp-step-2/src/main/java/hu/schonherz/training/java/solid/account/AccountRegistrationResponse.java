package hu.schonherz.training.java.solid.account;

import java.util.List;

import hu.schonherz.training.java.solid.account.model.Account;

public class AccountRegistrationResponse {

  private List<String> validationErrors;
  private Account account;

  public AccountRegistrationResponse(List<String> validationErrors, Account account) {
    this.validationErrors = validationErrors;
    this.account = account;
  }

  public List<String> getValidationErrors() {
    return validationErrors;
  }

  public Account getAccount() {
    return account;
  }
}
