package com.example.demo.Validator;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


public class ObjectsValidator {
	
	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	  private final Validator validator = factory.getValidator();

	  public <T> void validate(T objectToValidate) {
	    Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
	    if (!violations.isEmpty()) {
	      Set<String> errorMessages = violations.stream()
	          .map(ConstraintViolation::getMessage)
	          .collect(Collectors.toSet());
	      throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
	    }
	  }

}
