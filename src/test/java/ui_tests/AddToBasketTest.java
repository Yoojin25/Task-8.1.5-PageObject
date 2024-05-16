package ui_tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asserts.Assert;

import static pages.BasketPage.*;
import static pages.HeaderPage.counterOfBasket;
import static pages.SearchQueryResultPage.*;
import static steps.Steps.getElementText;

public class AddToBasketTest extends BaseTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Осуществляется переход на страницу с бытовой техникой; товар добавляется в корзину; название и цена " +
            "товара в корзине соответствуют названию и цене на странице каталога")
    public void addToBasketTest() {
        headerPage
                .clickOnCatalog()
                .moveToAppliances()
                .clickOnHomeAppliances()
                .clickOnCleaners()
                .clickOnCleanersNext()
                .addToBasket();

//      Проверка, что отображается "Пылесосы и пароочистители"
        Assert.textPresence(cleanersCatalogTitle, "Пылесосы и пароочистители");

//      Проверка, что путь фильтра: "Главная" - "Бытовая техника" - "Техника для дома" - "Пылесосы и пароочистители"
        Assert.textPresence(filterPath, "Главная\nБытовая техника\nТехника для дома\nПылесосы и пароочистители");

        String productNameOnPageText = getElementText(productNameOnPage);
        String productPriceOnPageText = getElementText(productPriceOnPage);

//      Проверка, что в правом верхнем углу над логотипом "Корзина" появилась красная цифра “1”
        Assert.textPresence(counterOfBasket, "1");

        headerPage
                .clickOnBasket();

//      Проверка, что текст и цена товара соответствует цене и названию товара из предыдущих шагов
        String productNameInBasketText = getElementText(productNameInBasket);
        String productPriceInBasketText = getElementText(productPriceInBasket);

        Assert.textMatch(productNameOnPageText, productNameInBasketText);
        Assert.textMatch(productPriceOnPageText, productPriceInBasketText);

//      Проверка, что "Итого" = сумме товара
        String priceAllProductsText = getElementText(priceAllProducts);
        String totalPriceText = getElementText(totalPrice);

        Assert.textMatch(priceAllProductsText, totalPriceText);

//      Проверка, что кнопка "Заказать" активна для нажатия
        Assert.checkVisibleAndClickable(orderButton);
    }
}
