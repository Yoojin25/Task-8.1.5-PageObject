package ui_tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.Assert;

import static pages.FiltersPage.*;
import static pages.SearchQueryResultPage.*;
import static steps.Steps.getElementText;

public class FiltersTest extends BaseTest {

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтры активируются; выбранные фильтры отображаются на странице каталога; количество товара на " +
            "странице фильтров соответствует количеству на странице каталога")
    public void filtersTest() {
        headerPage
                .clickOnCatalog()
                .moveToElectronics()
                .clickOnLaptopsAndPc()
                .clickOnLaptops()
                .clickOnAllFilters()
                .fillPriceRange("100000", "149000")
                .selectFilter(radioMax3Days)
                .selectFilter(brand)
                .selectFilter(screen)
                .filterProducts();

//      Проверка, что открылась страница с ноутбуками
        Assert.textPresence(laptopsCatalogTitle, "Ноутбуки и ультрабуки");

//      Проверка, что выбранные фильтры отображаются на странице
        Assert.assertAllFiltersVisible(radioMax3DaysOnPage, priceRangeOnPage, brandOnPage, screenOnPage);

//      Проверка, что появилась кнопка "Сбросить все"
        Assert.checkVisibleAndClickable(resetFilters);

//      Проверка, что кол-во товара на странице фильтров = количеству товара на странице
        searchQueryResultPage
                .clickOnAllFilters();

        String numberOfProductsFiltersText = getElementText(numberOfProductsFilters);
        String numberOfProductsCatalogText = getElementText(numberOfProductsCatalog);

        Assert.textMatch(numberOfProductsFiltersText, numberOfProductsCatalogText);

//      Проверка, что фильтр активировался
        Assert.checkFilterIsActivated(radioMax3DaysActive, "class", "radio-with-text j-list-item selected");
        Assert.checkFilterIsActivated(brandActive, "class", "checkbox-with-text j-list-item selected");
        Assert.checkFilterIsActivated(screenActive, "class", "checkbox-with-text j-list-item selected");
    }
}
