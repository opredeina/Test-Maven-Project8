package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomAddress;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomPhone;
import static utils.RandomUtils.getRandomString;

import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class RegistrationWithRandomUtilsTests {

  @Test
  void shouldFillSelenideRegistration() {

    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String userEmail = getRandomEmail();
    String userNumber = getRandomPhone();
    String currentAddress = getRandomAddress();

    //открыть страницу
    open("https://demoqa.com/automation-practice-form/");
    //ввести имя
    $("[id='firstName']").setValue("firstName");
    //ввести фамилию
    $("[id='lastName']").setValue("lastName");
    //ввести почту
    $("[id='userEmail']").setValue("userEmail");
    //заполнить чек-бокс
    $("#genterWrapper").$(new ByText("Female")).click();
    //$(byAttribute("for", "gender-radio-2")).click();
    //ввести номер телефона
    $("[id='userNumber']").setValue("userNumber");
    //ввести адрес
    $("[id='currentAddress']").setValue("currentAddress");
    //кликнуть по кнопке
    $("[type='submit']").click();
    //проверка: во всплывающем окне есть текст Thanks for submitting the form
    $(".modal-header").shouldHave(text("Thanks for submitting the form"));

  }

}
