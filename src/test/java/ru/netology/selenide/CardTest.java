package ru.netology.selenide;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardTest {
private String generateDate(int addDays, String pattern) {
    return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
}
@Test
    public void shouldBeSuccessful() {

}



}
