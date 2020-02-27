package ua.com.DateApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.DateApplication.config.BeanConfiguration;
import ua.com.DateApplication.controller.DateController;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    DateController dc = ac.getBean(DateController.class);
    dc.runConsole();
  }

}
