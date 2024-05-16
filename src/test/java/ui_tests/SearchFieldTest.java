package ui_tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.Assert;

import static general.Constants.PHONE_MODEL;
import static pages.HeaderPage.*;
import static pages.SearchQueryResultPage.*;

public class SearchFieldTest extends BaseTest {

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Текст 'Iphone 13' присутствует; первый фильтр пустой; применен фильтр 'По популярности'; у первого " +
            "устройства из списка бренд - Apple")
    public void searchFieldTest() {
        headerPage
                .findProduct(PHONE_MODEL)
                .clearSearchField();

//      Проверить что присутствует текст "По запросу Iphone 13 найдено"
        Assert.textPresence(searchingResult, PHONE_MODEL);

//      Проверить что первый фильтр - iphone 13 (там теперь пусто)
        Assert.emptyElement(filterFirst);

//      Проверить что применен фильтр "По популярности"
        Assert.textPresence(filterByPopularity, "По популярности");

//      Проверить что у первого устройства из списка бренд - Apple
        Assert.textPresence(firstProductBrand, "Apple");

//      Проверить, что строка стала пустой
        Assert.emptyElement(searchField);
    }
}
