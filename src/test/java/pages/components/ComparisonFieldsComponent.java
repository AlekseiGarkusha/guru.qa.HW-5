package pages.components;

import data.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

  public class ComparisonFieldsComponent {

    public void checkField(String fieldName, String expectedValue) {
      $(".table-responsive")
        .$(byText(fieldName))
        .parent()
        .shouldHave(partialText((expectedValue)));
    }

    public void comparisonFieldsPositiveTest(TestData testData) {
      checkField("Student Name", (testData.userFakerFirstName + " " + testData.userFakerLastName));
      checkField("Student Email", testData.userFakerEmail);
      checkField("Gender", (testData.userFakerGender));
      checkField("Mobile", (testData.userFakerNumber));
      checkField("Date of Birth", testData.userFakerDay + " " + testData.userFakerMonth + "," + testData.userFakerYear);
      checkField("Subjects", (testData.userFakerSubject));
      checkField("Hobbies", (testData.userFakerHobby));
      checkField("Picture", (testData.userPicture));
      checkField("Address", (testData.userCurrentAddress));
      checkField("State and City", (testData.userFakerState + " " + testData.userFakerCity));
    }

  }


