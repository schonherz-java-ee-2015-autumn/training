package hu.schonherz.training.java.solid.account.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.account.AccountRegistrationRequest;
import hu.schonherz.training.java.solid.validator.ValidationRule;
import hu.schonherz.training.java.solid.validator.Violation;

public class MandatoryUsernameRule implements ValidationRule<AccountRegistrationRequest> {

  @Override
  public List<Violation> validate(AccountRegistrationRequest object) {
    Validate.notNull(object);
    return StringUtils.isBlank(object.getUsername()) ? Arrays.asList(new Violation("username",
        "Username must be entered")) : Collections.<Violation>emptyList();
  }

}
