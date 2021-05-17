package api;

import com.epam.locators.config.WebDriverConfiguration;
import com.epam.locators.enumeration.SupportedDrivers;
import com.epam.locators.utils.PageStorage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected PageStorage storage;
    protected WebDriver driver;


    @BeforeClass
    public void initDriver() {
        driver = WebDriverConfiguration.setWebDriver(SupportedDrivers.CHROME);
        WebDriverConfiguration.maximizeWindow();
        storage = new PageStorage();
          }

    @AfterClass
    public void tearDown() {
        WebDriverConfiguration.clearCookies();
        WebDriverConfiguration.tearDown();
    }

}