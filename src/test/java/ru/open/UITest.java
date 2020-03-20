package ru.open;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class UITest {

    @Test
    public void firstTest() {
        open("https://www.google.com/");

        GoogleMainPageObject googleMainPO = new GoogleMainPageObject();
        googleMainPO.search("Открытие");

        GoogleResultsPageObject googleResultsPO = new GoogleResultsPageObject();
        googleResultsPO.getListOfWebElements().findBy(text("www.open.ru")).click();

        OpenMainPageObject openMainPO = new OpenMainPageObject();
        List<Double> listOfRates = openMainPO.getListOfRates();
        boolean check1 = false;
        if (listOfRates.get(0) < listOfRates.get(1) || listOfRates.get(2) < listOfRates.get(3)) { // 0 - USD BUY; 1 - USD SELL; 2 - EUR BUY; 3 - USD SELL;
            check1 = true;
        }
        Assert.assertTrue(check1);
    }
}
