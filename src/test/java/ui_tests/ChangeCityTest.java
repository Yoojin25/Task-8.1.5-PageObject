package ui_tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.Assert;

import static general.Constants.*;
import static pages.AddressPage.*;
import static steps.Steps.getElementText;

public class ChangeCityTest extends BaseTest {

    @Test
    @DisplayName("Смена города")
    @Description("Осуществляются переходы на страницы пункта выдачи и на главную страницу WB, адреса совпадают")
    public void changeCityTest() {
        headerPage
                .clickOnChangeCity()
                .inputCityInSearch(CITY);

        String firstAddressText = getElementText(firstAddress);

        addressPage
                .clickOnFirstAddress();

//      Проверка, что открылась информация о центре выдачи
        Assert.passToPickPointPage(listOfPickPointsPage, selectedPickPointPage);

        String addressSelectedPickPointText = getElementText(addressSelectedPickPoint);

//      Проверка, что адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов
        Assert.textMatch(firstAddressText, addressSelectedPickPointText);

        addressPage
                .selectFirstAddress();

//      Проверка, что произошел переход на главную страницу WB
        Assert.passToHomePage(homePageUrl, "href", URL_WB);

//      Проверка, что отображается адрес пункта выдачи из предыдущего шага
        String addressOnHomePageText = getElementText(addressOnHomePage);

        Assert.textMatch(addressSelectedPickPointText, addressOnHomePageText);
    }
}
