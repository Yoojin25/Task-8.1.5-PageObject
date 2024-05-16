package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    public static SelenideElement appliancesCatalog = $x("//a[contains(@class, '16107')]");
    public static SelenideElement homeAppliancesCatalog = $x("//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement cleanersCatalog = $x("//span[contains(text(), 'Пылесосы и пароочистители')]");
    public static SelenideElement cleanersCatalogNext = $x("//a[contains(@class, 'j-menu-drop-link') and contains(text(), 'Пылесосы и пароочистители')]");
    public static SelenideElement electronicsCatalog = $x("//a[contains(@class, '4830')]");
    public static SelenideElement laptopsAndPcCatalog = $x("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptopsCatalog = $x("//a[contains(@class, 'menu-burger__link') and text()='Ноутбуки']");
    public static SelenideElement loadFirstProduct = $x("//div[@class='main-page__content']//article[1]");

    public CatalogPage moveToAppliances() {
        appliancesCatalog.shouldBe(visible, enabled).hover();

        return this;
    }

    public CatalogPage clickOnHomeAppliances() {
        homeAppliancesCatalog.shouldBe(visible).hover().shouldBe(interactable).click();

        return this;
    }

    public CatalogPage clickOnCleaners() {
        cleanersCatalog.shouldBe(visible).hover().shouldBe(interactable).click();

        return this;
    }

    public SearchQueryResultPage clickOnCleanersNext() {
        cleanersCatalogNext.shouldBe(visible).hover().shouldBe(interactable).click();

        return new SearchQueryResultPage();
    }

    public CatalogPage moveToElectronics() {
        electronicsCatalog.shouldBe(visible, enabled).hover();

        return this;
    }

    public CatalogPage clickOnLaptopsAndPc() {
        laptopsAndPcCatalog.shouldBe(visible).hover().shouldBe(interactable).click();

        return this;
    }

    public SearchQueryResultPage clickOnLaptops() {
        laptopsCatalog.shouldBe(visible).hover().shouldBe(interactable).click();

        return new SearchQueryResultPage();
    }
}
