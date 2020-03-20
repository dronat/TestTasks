package ru.open;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleMainPageObject {
    private SelenideElement searchArea = $(byXpath("//input[@class=\"gLFyf gsfi\"]"));
    private SelenideElement searchButton = $(byXpath("//input[@value=\"Поиск в Google\"]"));

    void search(String searchText) {
        searchArea.setValue(searchText);
        searchButton.click();
    }
}
