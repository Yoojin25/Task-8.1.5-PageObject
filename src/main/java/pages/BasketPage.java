package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {
    public static SelenideElement productNameInBasket = $x("//span[@class='good-info__good-name']");
    public static SelenideElement productPriceInBasket = $x("//div[contains(@data-link, 'priceSumWith')]");
    public static SelenideElement chatButton = $x("//button[contains(@class, 'btn-chat')]");
    public static SelenideElement priceAllProducts = $x("//span[@class='b-right']");
    public static SelenideElement totalPrice = $x("//span[contains(@data-link, 'totalPaymentFee')]");
    public static SelenideElement orderButton = $x("//button[@name='ConfirmOrderByRegisteredUser']");
}
