package hu.schonherz.training.java.solid.validator;

import java.util.List;

public interface ValidationRule<T> {

  List<Violation> validate(T object);

}
