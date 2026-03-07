package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {

    public String day = "26";
    public  String month = "March";
    public String year = "1991";

    private final SelenideElement userBirthDate = $("#dateOfBirthInput");
    private final SelenideElement userBirthDaу = $(".react-datepicker__day react-datepicker__day--0" + day + "");
    private final SelenideElement userBirthMonth = $(".react-datepicker__month-select").setValue(month);
    private final SelenideElement userBirthYear = $(".react-datepicker__year-select").setValue(year);

    private final SelenideElement userFirstName = $("#firstName");
    private final SelenideElement userLastName = $("#lastName");
    private final SelenideElement userEmail= $("#userEmail");
    private final SelenideElement userGenderMale= $(byText("Male"));
    private final SelenideElement userNumber= $("#userNumber");

    private final SelenideElement userHobbySports = $(byText("Sports"));
    private final SelenideElement userHobbyReading= $(byText("Reading"));
    private final SelenideElement userHobbyMusic = $(byText("Music"));

    public TextBoxPage typeUserFirstName(String value) {
        userFirstName.sendKeys(value);
        return this;
    }

    public TextBoxPage typeUserLastName(String value) {
        userLastName.sendKeys(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmail.sendKeys(value);
        return this;
    }

    public TextBoxPage setUserGenderMale(String value) {
        userGenderMale.sendKeys(value);
        return this;
    }

    public TextBoxPage typeUserNumber(String value) {
        userNumber.sendKeys(value);
        return this;
    }

    public TextBoxPage typeUserHobbySports(String value) {
        userHobbySports.sendKeys(value);
        return this;
    }

    public TextBoxPage typeUserBirthDay() {

    }


}
