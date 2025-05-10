import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Alekseev");
        $("#userEmail").setValue("aetirodev@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='1991']").click();
        $("[class=react-datepicker__month-select]>[value='10']").click();
        $(".react-datepicker__month .react-datepicker__day--012").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("photo.png");
        $("#currentAddress").setValue("district 9");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Vladimir Alekseev"));
        $(".table-responsive").shouldHave(text("aetirodev@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("12 November,1991"));
        $(".table-responsive").shouldHave(text("Arts, Computer Science"));
        $(".table-responsive").shouldHave(text("Reading, Music"));
        $(".table-responsive").shouldHave(text("photo.png"));
        $(".table-responsive").shouldHave(text("district 9"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));
    }
}
