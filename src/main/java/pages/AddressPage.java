package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static general.Constants.CITY;

public class AddressPage {
    public static SelenideElement addressInput = $x("//input[contains(@class, 'ymaps')]");
    public static SelenideElement firstAddress = $x("(//span[@class='address-item__name-text'])[1]");
    public static SelenideElement listOfPickPointsPage = $x("//div[@class='geo-block__info']");
    public static SelenideElement selectedPickPointPage = $x("//div[@class='details-self']");
    public static SelenideElement addressSelectedPickPoint = $x("//span[@class='details-self__name-text']");
    public static SelenideElement selectButton = $x("//button[@class='details-self__btn btn-main']");
    public static SelenideElement homePageUrl = $x("//base");
    public static SelenideElement addressOnHomePage = $x("//span[@data-wba-header-name='DLV_Adress']");

    public AddressPage inputCityInSearch(String product) {
        actions().moveToElement(addressInput.shouldBe(visible, interactable))
                .click()
                .sendKeys(product, Keys.ENTER)
                .perform();

        return this;
    }

    public AddressPage clickOnFirstAddress() {
        firstAddress.shouldHave(text(CITY)).click();

        return this;
    }

    public AddressPage selectFirstAddress() {
        selectButton.click();

        return new AddressPage();
    }
}
