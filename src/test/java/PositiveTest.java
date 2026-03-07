/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.CalendarComponent;
import pages.TextBoxPage;
import setup.TestBase;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.DataErrorMessages.*;
import static data.ExpectedUserData.*;
import static data.NavData.*;
import static data.NavData.goToPracticeForm;
import static data.UserData.*;

public class PositiveTest extends TestBase {
  TextBoxPage textBoxPage = new TextBoxPage();
  CalendarComponent calendarComponent = new CalendarComponent();

  public String day = "26";
  public  String month = "March";
  public String year = "1991";

  @Test
  public void goToPracticeForm() {
    openForm();

    $x(goToTestForms).click();
    $(byText(clickTestFormsMenu)).scrollIntoView(true).shouldBe(visible).click();
    $(byText(goToPracticeForm)).scrollIntoView(true).shouldBe(visible).click();

    SelenideElement findForm = $(practiceForm).shouldBe(visible);
    Assertions.assertTrue(findForm.exists(), notFinedPracticeFormTitle);

    // Заполенние всех полей
      textBoxPage
        .typeUserFirstName(expectedUserFirstName)
        .typeUserLastName(expectedUserLastName)
        .typeUserEmail(expectedUserEmail)
        .typeUserNumber(expectedUserNumber);

        calendarComponent.
          typeUserBirthDate(year, month, day);

    $(byText(expectedUserBirthMonth)).shouldBe(visible).click();
    $(byText(expectedUserBirthYear)).shouldBe(visible).click();

    $(byText(expectedUserBirthDay)).click();



    $(userUploadFile).uploadFromClasspath(expectedUserPhoto);

    $(userCurrentAddress).sendKeys(expectedUserCurrentAddress);

    $(userStateDropdown).shouldBe(visible).click();
    $(byText(userStateNCR)).shouldBe(visible).click();

    $(userCityDropdown).shouldBe(visible).click();
    $(byText(userCityNoida)).shouldBe(visible).click();

    $(btnSubmit).click();

    //Проверка на соответсвиет полей")
    SelenideElement formResult = $(byText(resultFormTitle));
    Assertions.assertTrue(formResult.exists(), notFinedResultFormTitle);

    List<String> expectedValues = List.of(
      expectedUserFirstAndLastName,
      expectedUserEmail,
      expectedUserGender,
      expectedUserNumber,
      expectedUserBirthDate,
      expectedUserSubjects,
      expectedUserPhoto,
      expectedUserCurrentAddress,
      expectedUserStateAndCity
    );

    $$(resultFormDataActualList).shouldHave(texts(expectedValues));
  }
}
