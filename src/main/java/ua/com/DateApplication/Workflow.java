package ua.com.DateApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ua.com.DateApplication.controller.DateController;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class Workflow {

  private static final Logger log = LoggerFactory.getLogger(DateController.class);

  private final DateController dateController;

  public Workflow(DateController dateController) {
    this.dateController = dateController;
  }

  @PostConstruct
  public void run(){
    log.info("1 - run application via console input;" +
      "\n2 - run application via file reading;");

    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    if(choice == 1){
      dateController.runConsole();
    } else if(choice == 2) {
      dateController.runFileDates();
    }
  }

}
