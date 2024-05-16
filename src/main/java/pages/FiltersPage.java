package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class FiltersPage {

    public static SelenideElement allFilters = $x("//button[contains(@class, 'dropdown-filter__btn--all')]");
    public static SelenideElement minPrice = $x("//input[@name='startN']");
    public static SelenideElement maxPrice = $x("//input[@name='endN']");
    public static SelenideElement radioMax3Days = $x("//span[@class='radio-with-text__text' and text()='до 3 дней']");
    public static SelenideElement brand = $x("//span[text()='Apple']");
    public static SelenideElement screen = $x("//span[text()='13.3\"']");
    public static SelenideElement filterResult = $x("//button[@class='filters-desktop__btn-main btn-main']");
    public static SelenideElement numberOfProductsFilters = $x("//p[@class='filters-desktop__count-goods']");
    public static SelenideElement radioMax3DaysActive = $x("//span[@class='radio-with-text__text' and text()='до 3 дней']/..");
    public static SelenideElement brandActive = $x("//span[@class='checkbox-with-text__text' and text()='Apple']/..");
    public static SelenideElement screenActive = $x("//span[@class='checkbox-with-text__text' and text()='13.3\"']/..");

    public FiltersPage fillPriceRange(String min, String max) {
        minPrice.shouldBe(visible, interactable).clear();
        minPrice.shouldBe(visible, empty).sendKeys(min);

        maxPrice.shouldBe(visible, interactable).clear();
        maxPrice.shouldBe(visible, empty).sendKeys(max);

        return this;
    }

    public FiltersPage selectFilter(SelenideElement element) {
        element.shouldBe(visible, interactable).click();

        return this;
    }

    public SearchQueryResultPage filterProducts() {
        filterResult.shouldBe(visible, interactable).click();

        return new SearchQueryResultPage();
    }
}
