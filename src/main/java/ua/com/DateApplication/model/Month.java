package ua.com.DateApplication.model;

public enum Month {
  JANUARY(1, 31), FEBRUARY(2, 28), MARCH(3, 31), APRIL(4, 30), MAY(5, 31), JUNE(6, 30), JULY(7, 31), AUGUST(8, 31), SEPTEMBER(9, 30), OCTOBER(10, 31), NOVEMBER(11, 30), DECEMBER(12, 31);

  private final int amountOfTheDay;
  private final int monthNumber;

  Month(int monthNumber, int amountOfTheDay) {
    this.amountOfTheDay = amountOfTheDay;
    this.monthNumber = monthNumber;
  }

  public static Month getByNumber(int number) {
    for (Month m : Month.values()) {
      if(m.getMonthNumber() == number){
        return m;
      }
    }
    return null;
  }

  public int getAmountOfTheDay() {
    return amountOfTheDay;
  }

  public int getMonthNumber() {
    return monthNumber;
  }
}
