  /**
   * Позитивный тест:
   * - переход к странице формы
   * - проверка на загрузку мормы (нахождение form wrapper)
   * - заполненме всех полей
   * - проверка на открытие результирующей формы - метод поиска title формы
   * - сравнение результирующий полей с вводимыми
   */

  package tests;

  import data.TestData;
  import org.junit.jupiter.api.*;
  import pages.RegistrationPage;
  import pages.components.ComparisonFieldsComponent;
  import setup.TestBase;

  public class PositiveTest extends TestBase {

    @Test
    public void practiceFormTest() {
      RegistrationPage registrationPage = new RegistrationPage();
      ComparisonFieldsComponent comparisonFields = new ComparisonFieldsComponent();
      TestData testData = new TestData();

      registrationPage
        .openPage()
        .typeUserName(testData.userFakerFirstName,testData.userFakerLastName)
        .typeUserEmail(testData.userFakerEmail)
        .chooseGender(testData.userFakerGender)
        .typeUserNumber(testData.userFakerNumber)
        .setDateOfBirth(testData.userFakerDay, testData.userFakerMonth,testData.userFakerYear)
        .setUserSubjets(testData.userFakerSubject)
        .setUserHobbies(testData.userFakerHobby)
        .uploadPicture(testData.userPicture)
        .typeUserCurrentAddress(testData.userCurrentAddress)
        .setStateAndCity(testData.userFakerState, testData.userFakerCity)
        .clickBtnSubmit();

      comparisonFields.comparisonFieldsPositiveTest(testData);
    }
  }
