package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static pages.BasketPage.chatButton;
import static pages.CatalogPage.loadFirstProduct;

public class HeaderPage {
    public static SelenideElement searchField = $x("//input[@id='searchInput']");
    public static SelenideElement clearButton = $x("//button[contains(@class, 'btn--clear')]");
    public static SelenideElement addressButton = $x("//span[contains(@class, 'j-geocity-link')]");
    public static SelenideElement catalogButton = $x("//button[contains(@class, 'j-menu-burger-btn')]");
    public static SelenideElement counterOfBasket = $x("//span[@class='navbar-pc__notify']");
    public static SelenideElement basketButton = $x("//span[contains(@class, 'navbar-pc__icon--basket')]");

    public HeaderPage findProduct(String product) {
        actions().moveToElement(searchField.shouldBe(visible))
                .click()
                .sendKeys(product, Keys.ENTER)
                .perform();

        return this;
    }

    public HeaderPage clearSearchField() {
        clearButton.click();

        return this;
    }

    public AddressPage clickOnChangeCity() {
        addressButton.shouldBe(interactable).click();

        return new AddressPage();
    }

    public CatalogPage clickOnCatalog() {
        loadFirstProduct.shouldBe(visible);

        catalogButton.shouldBe(visible, interactable).click();

        return new CatalogPage();
    }

    public BasketPage clickOnBasket() {
        basketButton.click();

        chatButton.shouldBe(visible);

        return new BasketPage();
    }
}
