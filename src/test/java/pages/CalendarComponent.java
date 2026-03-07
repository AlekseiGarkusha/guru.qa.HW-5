package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


  public CalendarComponent typeUserBirthDate(String year, String month, String day) {
    userBirthDate.click();
    userBirthYear.setValue(year);
    userBirthMonth.setValue(month);
    userBirthDaу.setValue(day);
    return this;
  }


}
