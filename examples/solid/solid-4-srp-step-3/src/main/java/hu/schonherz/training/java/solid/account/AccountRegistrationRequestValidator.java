package hu.schonherz.training.java.solid.account;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class AccountRegistrationRequestValidator {
  public void validate(AccountRegistrationRequest request) throws ViolationException {
    Validate.notNull(request);

    List<Violation> violations = new LinkedList<>();
    if (request.getUsername() == null || request.getUsername().trim().length() == 0) {
      violations.add(new Violation("username", "Username must be entered"));
    }

    if (request.getPassword() == null || request.getPassword().trim().length() == 0) {
      violations.add(new Violation("password", "Password must be entered"));
    }

    if (request.getPasswordConfirmation() == null
        || request.getPasswordConfirmation().trim().length() == 0) {
      violations
          .add(new Violation("passwordConfirmation", "Password confirmation must be entered"));
    }

    if (request.getPassword() != null
        && !request.getPassword().equals(request.getPasswordConfirmation())) {
      violations.add(new Violation("passwordConfirmation",
          "Password confirmation must match the password entered"));
    }

    if (request.getEmail() == null || request.getEmail().trim().length() == 0) {
      violations.add(new Violation("email", "Email address must be entered"));
    }

    if (request.getEmail() != null
        && request.getEmail().trim().length() != 0
        && !request
            .getEmail()
            .trim()
            .matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
      violations.add(new Violation("email", "A valid email address must be entered"));
    }

    if (!violations.isEmpty()) {
      throw new ViolationException(violations);
    }
  }
}
