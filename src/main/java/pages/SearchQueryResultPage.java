package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static pages.FiltersPage.allFilters;

public class SearchQueryResultPage {
    public static SelenideElement searchingResult = $x("//h1");
    public static SelenideElement filterFirst = $x("//button[contains(@class, 'btn--burger')]");
    public static SelenideElement filterByPopularity = $x("//button[contains(@class, 'btn--sorter')]");
    public static SelenideElement firstProductBrand = $x("//article[1]//span[@class='product-card__brand']");
    public static SelenideElement cleanersCatalogTitle = $x("//h1[@class='catalog-title']");
    public static SelenideElement filterPath = $x("//div[@class='breadcrumbs__container']");
    public static SelenideElement addToBasketButton = $x("//article[1]//a[@href='/lk/basket']");
    public static SelenideElement cookiesButton = $x("//button[@class='cookies__btn btn-minor-md']");
    public static SelenideElement productNameOnPage = $x("//article[1]//span[@class='product-card__name']");
    public static SelenideElement productPriceOnPage = $x("//article[1]//ins");
    public static SelenideElement laptopsCatalogTitle = $x("//h1[@class='catalog-title']");
    public static SelenideElement radioMax3DaysOnPage = $x("//span[@class='your-choice__btn' and text()='до 3 дней']");
    public static SelenideElement priceRangeOnPage = $x("//span[@class='your-choice__btn' and text()='от 100 000 до 149 000']");
    public static SelenideElement brandOnPage = $x("//span[@class='your-choice__btn' and text()='Apple']");
    public static SelenideElement screenOnPage = $x("//span[@class='your-choice__btn' and text()='13.3\"']");
    public static SelenideElement resetFilters = $x("//button[@data-link='{on resetAllFiltres}']");
    public static SelenideElement numberOfProductsCatalog = $x("//span[@class='goods-count']");

    public SearchQueryResultPage addToBasket() {
        cookiesButton.click();

        addToBasketButton.shouldBe(visible).click();

        return this;
    }

    public FiltersPage clickOnAllFilters() {
        allFilters.shouldBe(interactable).click();

        return new FiltersPage();
    }
}
