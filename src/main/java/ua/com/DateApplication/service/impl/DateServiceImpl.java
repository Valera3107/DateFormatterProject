package ua.com.DateApplication.service.impl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.com.DateApplication.model.Date;
import ua.com.DateApplication.model.Month;
import ua.com.DateApplication.service.DateService;
import ua.com.DateApplication.validator.interfaces.ValidDate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DateServiceImpl implements DateService {

//  private static final Logger log = LoggerFactory.getLogger(DateServiceImpl.class);

  private static final Pattern pattern = Pattern.compile("^(\\d{2}) (\\d{2}) (\\d{4}), (\\d{2}) (\\d{2}) (\\d{4})$");

  @Override
  public void writeToFileDates(String fileName) {
    try (FileWriter writer = new FileWriter(fileName, false)) {
      String text = "12 05 2000, 08 04 1909\n02 10 2009, 01 07 1945\n11 02 1987, 23 05 1999";
      writer.write(text);
      writer.flush();
//      log.info("Wrote to the " + fileName + " file three pairs of the date;");
    } catch (IOException ex) {
//      log.error("Can not write to " + fileName + ";");
    }
  }

  @Override
  public void dateConversion(String stringDate) {
    Matcher matcher = pattern.matcher(stringDate);
    Date date1;
    Date date2;
    long numberOfDays1;
    long numberOfDays2;
    if (matcher.matches()) {
      date1 = createDate(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
      date2 = createDate(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
//      log.info("Created 2 dates from source;");
    } else {
//      log.error("Format input is invalid!");
      return;
    }

    numberOfDays1 = calcDays(date1);
    numberOfDays2 = calcDays(date2);

    printResult(date1, date2, numberOfDays1, numberOfDays2);
  }

  @Override
  @ValidDate
  public Date createDate(int day, int month, int year) {
//    log.info("Created Date object from day, month and year;");
    return new Date(day, month, year);
  }

  @Override
  public long calcDays(Date date) {
    long sum = 0;
    for (int year = date.getYear(); year > 0; year--) {
      if (year % 4 == 0) {
        sum += 366;
      } else {
        sum += 365;
      }
    }

    for (int month = 1; month <= date.getMonth(); month++) {
      sum += Month.getByNumber(month).getAmountOfTheDay();
    }

    sum += date.getDay();

//    log.info("Calculated a number of the days for Date object;");

    return sum;
  }

  private void printResult(Date date1, Date date2, long numberOfDays1, long numberOfDays2) {
//    log.info("Printed result of calculations;");
    if (numberOfDays1 > numberOfDays2) {
      System.out.println(dateFormatPrint(date1) + ", " + dateFormatPrint(date2) + ", " + (numberOfDays1 - numberOfDays2));
    } else {
      System.out.println(dateFormatPrint(date2) + ", " + dateFormatPrint(date1) + ", " + (numberOfDays2 - numberOfDays1));
    }
  }

  private String dateFormatPrint(Date date) {
//    log.info("Made normal form output for Date object;");
    String day = date.getDay() < 10 ? "0" + date.getDay() : String.valueOf(date.getDay());
    String month = date.getMonth() < 10 ? "0" + date.getMonth() : String.valueOf(date.getMonth());
    return day + " " + month + " " + date.getYear();
  }
}
