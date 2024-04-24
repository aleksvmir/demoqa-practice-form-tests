import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form"); // Открываем страницу
        $("#firstName").setValue("Vladimir"); // Заполняем поле "Имя"
        $("#lastName").setValue("Alekseev"); // Заполняем поле "Фамилия"
        $("#userEmail").setValue("aetirodev@gmail.com"); // Заполняем поле "Email"
        $("label[for='gender-radio-1']").click(); // Выбираем мужской пол
        $("#userNumber").setValue("0123456789"); // Заполняем поле "Номер телефона"
        $("[id=dateOfBirthInput]").click(); // Кликаем для ввода даты рождения
        $("[class=react-datepicker__year-select]>[value='1991']").click(); // Выбираем год рождения
        $("[class=react-datepicker__month-select]>[value='10']").click(); // Выбираем месяц рождения
        $(".react-datepicker__month .react-datepicker__day--012").click(); // Выбираем день рождения
        $("#subjectsContainer").click(); // Кликаем для выбора предмета
        $("#subjectsInput").setValue("Arts").pressEnter(); // Выбираем предмет "Arts"
        $("#subjectsInput").setValue("Computer Science").pressEnter(); // Выбираем предмет "Computer Science"
        $("label[for='hobbies-checkbox-2']").click(); // Выбираем хобби "Reading"
        $("label[for='hobbies-checkbox-3']").click(); // Выбираем хобби "Music"
        $("#uploadPicture").uploadFromClasspath("photo.png"); // Загружаем изображение
        $("#currentAddress").setValue("district 9"); // Заполняем поле "Адрес"
        $("#state").click(); // Кликаем для выбора штата
        $("#react-select-3-input").setValue("Haryana").pressEnter(); // Выбираем штат "Haryana"
        $("#city").click(); // Кликаем для выбора города
        $("#react-select-4-input").setValue("Panipat").pressEnter(); // Выбираем город "Karnal"
        $("#submit").click(); // Нажимаем кнопку "Submit"

        // Проверяем, что введенные данные отображаются корректно
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