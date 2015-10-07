package hu.schonherz.training.java.solid.account;

import java.util.LinkedList;
import java.util.List;

public class AccountRegistrationRequestValidator {
  public List<String> validate(AccountRegistrationRequest request) {
    List<String> validationErrors = new LinkedList<>();
    if (request.getUsername() == null || request.getUsername().trim().length() == 0) {
      validationErrors.add("Username must be entered");
    }

    if (request.getPassword() == null || request.getPassword().trim().length() == 0) {
      validationErrors.add("Password must be entered");
    }

    if (request.getPasswordConfirmation() == null
        || request.getPasswordConfirmation().trim().length() == 0) {
      validationErrors.add("Password confirmation must be entered");
    }

    if (request.getPassword() != null
        && !request.getPassword().equals(request.getPasswordConfirmation())) {
      validationErrors.add("Password confirmation must match the password entered");
    }

    if (request.getEmail() == null || request.getEmail().trim().length() == 0) {
      validationErrors.add("Email address must be entered");
    }

    if (request.getEmail() != null
        && !request
            .getEmail()
            .trim()
            .matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
      validationErrors.add("A valid email address must be entered");
    }
    return validationErrors;
  }
}
