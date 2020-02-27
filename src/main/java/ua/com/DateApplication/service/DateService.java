package ua.com.DateApplication.service;

import org.springframework.stereotype.Service;
import ua.com.DateApplication.model.Date;

/*
 * Basic functionality to work with {@link Date} Date.
 *
 * @author Valera
 * */


@Service
public interface DateService {

  /**
   * Create the Date object.
   * @param day format DD
   * @param month format MM
   * @param year format YYYY
   * @return created object
   */
  Date createDate(int day, int month, int year);

  /**
   * Write to three pairs of date
   * @param fileName path to file
   */
  void writeToFileDates(String fileName);

  /**
   * Convert string format to Date
   * @param stringDate string with DD MM YYYY, DD MM YYYY format
   */
  void dateConversion(String stringDate);

  /**
   * Calc a number of days in the Date
   * @param date object type of Date
   */
  long calcDays(Date date);
}
