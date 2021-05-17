package com.epam.locators.pages;

import com.epam.locators.config.WaitConfiguration;
import com.epam.locators.config.WebDriverConfiguration;
import com.epam.locators.exeptions.ValidationExceptions;
import com.epam.locators.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    public BasePage() {
        WaitConfiguration waitConfiguration = new WaitConfiguration.Builder()
                .setDefaultImplicitTimeUnit(TimeUnit.SECONDS)
                .setDefaultImplicitTimeout(10)
                .setDefaultExplicitTimeout(10)
                .build();

        WaitUtils.setWaitConfiguration(waitConfiguration);
    }

    public BasePage open() {
        getWebDriver().get(getUrl());
        return this;
    }

    public WebDriver getWebDriver() {
        return WebDriverConfiguration.getWebDriver();
    }

    public WebDriver initWebDriver(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else {
            return new FirefoxDriver();
        }
    }

    public void isPageOpen() throws ValidationExceptions.WrongPageOpenedException {
        if (!getWebDriver().getCurrentUrl().equals(getUrl())) {
            throw new ValidationExceptions
                    .WrongPageOpenedException(MessageFormat
                    .format("Wrong page URL! Expected : {0} Actual : {1}",getUrl(),getWebDriver().getCurrentUrl()));
        }
    }

    public abstract String getUrl();
}
