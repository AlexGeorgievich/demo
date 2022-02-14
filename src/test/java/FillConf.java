package runtest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//import static com.codeborne.selenide.Selenide.$;

public class FillConf extends runtest.BaseConf {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x2080";
//        Configuration.
//        String url = "https://demoqa.com/automation-practice-form";
    }

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
        $x("//*[@id='stateCity-wrapper']").$(byText(state)).scrollTo().click();
        $x("//div[@id='city']").click();
        $x("//*[@id='stateCity-wrapper']").$(byText(city)).click();

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
                text(state + " " + city));

        $("#closeLargeModal").click();
//        sleep(20000);       //  *** отладка

    }
}