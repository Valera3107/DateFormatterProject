package ua.com.DateApplication.validator.interfaces;


import ua.com.DateApplication.validator.impl.DateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
  String message() default "Date with such properties does not exist!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
