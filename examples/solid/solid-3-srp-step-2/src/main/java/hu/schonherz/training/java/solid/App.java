package hu.schonherz.training.java.solid;

import java.io.File;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.account.AccountRegistrationResponse;
import hu.schonherz.training.java.solid.account.AccountService;

public class App {

  public static void main(String[] args) {
    AccountService accountService =
        new AccountService("+d/Hd+CIMj/ochQmEcLGTg==", "WVyENBxRsmHQyYJWWahmfg==",
            System.getProperty("user.dir") + File.separator + "accounts.csv");

    // .. waiting for user interaction, then

    AccountRegistrationRequest request = new AccountRegistrationRequest();
    request.setUsername("testuser");
    request.setPassword("password");
    request.setPasswordConfirmation("password");
    request.setEmail("email@mail.com");
    AccountRegistrationResponse response = accountService.register(request);

    if (response == null) {
      System.err.println("Unable to register account");
    } else if (response.getValidationErrors() != null) {
      System.err.println("Validation errors:\n" + response.getValidationErrors());
    } else {
      System.out.println("Successful registration");
    }
  }

}
