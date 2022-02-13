package test;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x800";
//        Configuration.
//        String url = "https://demoqa.com/automation-practice-form";
    }
    // вынести в отдельный класс инициализации
    String firstName = "Alexander";
    String lastName = "Georgievich";
    String userEmail = "test@yandex.ru";
    String genterWrapper = "Male";
    String userNumber = "1122334455";
    String calendarMonth = "February";
    String calendarYear = "2000";
    String calendarDay  = "10";
    String subjectsInput = "Maths";
    String hobbiesWrapper = "Sports";
    String uploadPicture = "tools.png";
    String currentAddress = "Moscow, Red Square, Building 1, App 01";



    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(calendarMonth);
        $(".react-datepicker__year-select").selectOption(calendarYear);
        $(".react-datepicker__day--0"+calendarDay).click();

        $("#subjectsInput").setValue( subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbiesWrapper)).click();
//        $("#uploadPicture").uploadFromClasspath("src/test/resources/tools.png");
        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();

// var- 1
        $x("//*[@id='stateCity-wrapper']").$(byText("Haryana")).click();
        $x("//div[@id='city']").click();
        $x("//*[@id='stateCity-wrapper']").$(byText("Karnal")).click();

// var-2
//        $x("//*[text() = 'Haryana']").click();
//        $x("//*[@id ='city']").click();
//        $x("//*[text() ='Karnal']").click();
// var-3
//        $("#stateCity-wrapper").$(byText("Haryana")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();
        sleep(10000);      // *** отладка
//  results ----------------------------
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text( genterWrapper),
                text( userNumber),
                text(calendarDay + " " + calendarMonth + "," + calendarYear),
                text(subjectsInput),
                text(hobbiesWrapper),
                text(uploadPicture),
                text(currentAddress),
                text("Haryana" + " " + "Karnal"));

        $("#closeLargeModal").click();
//        sleep(20000);       //  *** отладка
    }
}