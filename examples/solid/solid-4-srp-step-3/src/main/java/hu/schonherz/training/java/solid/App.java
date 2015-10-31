package hu.schonherz.training.java.solid;

import hu.schonherz.training.java.solid.account.AccountRegistrationException;
import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountService;
import hu.schonherz.training.java.solid.account.model.Account;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class App {

  public static void main(String[] args) {
    AppFactory appFactory = new AppFactory();
    AccountService accountService = appFactory.getAccountService();

    // .. waiting for user interaction, then

    AccountRegistrationRequest request = new AccountRegistrationRequest();
    request.setUsername("testuser");
    request.setPassword("password");
    request.setPasswordConfirmation("password");
    request.setEmail("email@mail.com");

    try {
      Account account = accountService.register(request);
      if (account == null) {
        System.err.println("Unable to register account");
      } else {
        System.out.println("Successful registration");
      }
    } catch (ViolationException e) {
      System.err.println("Validation errors:\n" + e.getViolations());
    } catch (AccountRegistrationException e) {
      System.err.println("Registration failed, cause:");
      e.printStackTrace(System.err);
    }

    appFactory.close();
  }

}
