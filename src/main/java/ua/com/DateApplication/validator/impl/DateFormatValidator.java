package ua.com.DateApplication.validator.impl;

import ua.com.DateApplication.model.Month;
import ua.com.DateApplication.validator.interfaces.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class DateFormatValidator implements ConstraintValidator<ValidDate, Integer[]> {

  public boolean isValid(Integer[] integers, ConstraintValidatorContext constraintValidatorContext) {
    return validateDateInput(integers[0], integers[1], integers[2]);
  }

  private boolean validateDateInput(Integer day, Integer month, Integer year) {
    Month monthConst;
    if (year % 4 == 0 && month == 2 && day == 29) {
      return true;
    }
    return year >= 1900 && year <= 2010
      && month >= 1 && month <= 12
      && day >= 1 && day <= 31
      && (monthConst = Month.getByNumber(month)) != null
      && monthConst.getAmountOfTheDay() >= day;
  }
}
