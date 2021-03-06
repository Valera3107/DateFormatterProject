package ua.com.DateApplication.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ua.com.DateApplication.service.DateService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Validated
@Component
public class DateController {

  private static final Logger log = LoggerFactory.getLogger(DateController.class);

  private final DateService dateService;

  public DateController(DateService dateService) {
    this.dateService = dateService;
  }

  public void runConsole() {
    log.info("Input two dates with the next format: DD MM YYYY, DD MM YYYY");
    Scanner sc = new Scanner(System.in);
    String stringDate = sc.nextLine();
    dateService.dateConversion(stringDate);
  }

  public void runFileDates() {
    log.info("Input file name/path: (example dates.txt)");
    Scanner sc = new Scanner(System.in);
    String fileName = sc.nextLine();
    log.info("Read from {} information about the dates;", fileName);
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(
        fileName));
      String line = reader.readLine();
      while (line != null) {
        dateService.dateConversion(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      log.error("Can not open {};", fileName);
    }
  }


}
