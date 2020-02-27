package ua.com.DateApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.DateApplication.model.Date;
import ua.com.DateApplication.service.DateService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

  @Autowired
  private DateService dateService;

  @Test
  void createDate(){
    Date date = dateService.createDate(2, 2, 2000);
    assertEquals(new Date(2,2,2000), date);
  }

  @Test
  void calculateDays(){
    Date date = dateService.createDate(1,1,1900);
    assertEquals(694007,dateService.calcDays(date));
  }

  @Test
  void writeDateToTheFile(){
    dateService.writeToFileDates("test.txt");
    BufferedReader reader;
    int count = 0;
    try {
      reader = new BufferedReader(new FileReader(
        "test.txt"));
      String line = reader.readLine();
      while (line != null) {
        count++;
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals(3, count);

  }

}
