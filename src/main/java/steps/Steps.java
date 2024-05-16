package steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;

public class Steps {

    public static String getElementText(SelenideElement element) {
        return element.should(exist).getText();
    }
}
