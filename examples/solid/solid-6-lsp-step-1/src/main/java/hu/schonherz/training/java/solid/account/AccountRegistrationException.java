package hu.schonherz.training.java.solid.account;

public class AccountRegistrationException extends Exception {

  public AccountRegistrationException(String message) {
    super(message);
  }

  public AccountRegistrationException(Throwable cause) {
    super(cause);
  }

  public AccountRegistrationException(String message, Throwable cause) {
    super(message, cause);
  }

}
