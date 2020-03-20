package ru.open;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class OpenMainPageObject {
    private ArrayList<Double> listOfRates = new ArrayList<>();

    OpenMainPageObject() {
        $$(byXpath("//*[@class=\"main-page-exchange__rate\"]")).forEach(x -> listOfRates.add(Double.parseDouble(x.innerText().replace(",", "."))));
    }

    List<Double> getListOfRates() {
        return listOfRates;
    }
}
