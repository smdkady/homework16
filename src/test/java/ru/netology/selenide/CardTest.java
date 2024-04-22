package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardTest {
    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldBeSuccessful() {
        Selenide.open("http://localhost:9999");
        Selenide.$("[data-test-id='city'] input").setValue("Пенза");
        String planningDate = generateDate(4, "dd.MM.yyyy");
        Selenide.$("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        Selenide.$("[data-test-id='date'] input").setValue(planningDate);
        Selenide.$("[data-test-id='name'] input").setValue("Мамин-Сибиряк Дмитрий");
        Selenide.$("[data-test-id='phone'] input").setValue("+79998881234");
        Selenide.$("[data-test-id='agreement']").click();
        Selenide.$("button.button").click();
        Selenide.$(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(15)).shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));


    }


}

