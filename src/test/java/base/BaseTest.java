package base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static general.Constants.URL_WB;

public class BaseTest {
    protected HeaderPage headerPage = new HeaderPage();
    protected SearchQueryResultPage searchQueryResultPage = new SearchQueryResultPage();
    protected AddressPage addressPage = new AddressPage();

    @BeforeEach
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        Configuration.timeout = 6000;

        open(URL_WB);
    }
}
