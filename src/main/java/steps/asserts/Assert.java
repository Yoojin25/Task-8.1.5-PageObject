package steps.asserts;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Assert {

    public static void textPresence(SelenideElement element, String expectedResult) {
        assertThat(element.getText(), equalTo(expectedResult));
    }

    public static void emptyElement(SelenideElement element) {
        assertThat(element.getText(), isEmptyString());
    }

    public static void passToPickPointPage(SelenideElement listElement, SelenideElement selectedElement) {
        assertThat(listElement, not(equalTo(selectedElement)));
    }

    public static void passToHomePage(SelenideElement element, String attribute, String wbUrl) {
        assertThat(element.getAttribute(attribute), equalTo(wbUrl));
    }

    public static void textMatch(String text1, String text2) {
        if (text1.startsWith("/")) {
            text1 = text1.substring(2);
        } else if (text1.startsWith("Нашли")) {
            text1 = text1.substring(6);
        }

        assertThat(text1, equalTo(text2));
    }

    public static void checkVisibleAndClickable(SelenideElement element) {
        element.shouldBe(visible, interactable);
    }

    public static void assertAllFiltersVisible(SelenideElement... elements) {
        for (SelenideElement element : elements) {
            element.shouldBe(visible);
        }
    }

    public static void checkFilterIsActivated(SelenideElement element, String attributeName, String expectedAttributeValue) {
        element.shouldHave(attribute(attributeName, expectedAttributeValue));
    }
}
