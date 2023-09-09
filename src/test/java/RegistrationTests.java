import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    void beforeEach() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

    }

    @Test
    void fillFormTest() {
        $("#firstName").setValue("Капи");
        $("#lastName").setValue("Бара");
        $("#userEmail").setValue("capibara@gmail.com");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("capybara.jpg");
        $("#currentAddress").setValue("Пруд с апельсинами");
        $("#react-select-3-input").setValue("NC").pressEnter();
        $("#react-select-4-input").setValue("de").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(
                text("Капи Бара"),
                text("capibara@gmail.com"),
                text("Male"),
                text("1234567890"),
                text("25 November,2000"),
                text("Arts"),
                text("Sports, Reading, Music"),
                text("capybara.jpg"),
                text("Пруд с апельсинами"),
                text("NCR Delhi"));
    }
}
