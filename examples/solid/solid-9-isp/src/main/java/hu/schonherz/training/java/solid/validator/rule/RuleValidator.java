package hu.schonherz.training.java.solid.validator.rule;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;

public class RuleValidator<T> implements Validator<T> {

  private Collection<ValidationRule<T>> rules;

  public RuleValidator(Collection<ValidationRule<T>> rules) {
    Validate.notNull(rules);
    Validate.noNullElements(rules);
    this.rules = rules;
  }

  public void validate(T object) throws ViolationException {
    Validate.notNull(object);

    List<Violation> violations = new LinkedList<>();
    for (ValidationRule<T> rule : this.rules) {
      violations.addAll(rule.validate(object));
    }

    if (!violations.isEmpty()) {
      throw new ViolationException(violations);
    }
  }

}
