package ru.open;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPageObject {
    private ElementsCollection listOfLinks = $$(byXpath("//div[@class=\"TbwUpd NJjxre\"]//cite"));

    ElementsCollection getListOfWebElements() {
        return listOfLinks;
    }

}
