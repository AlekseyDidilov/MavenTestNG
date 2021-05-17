package com.epam.locators.pages;


import com.epam.locators.utils.WaitUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @Override
    public String getUrl() {
        return "https://allo.ua/ru/";
    }

    @Getter
    @FindBy(xpath = "//input[@id='search-form__input']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@class,'search-models')]")
    private List<WebElement> searchResultsLinks;

    @FindBy(xpath = "//div[contains(@class,'result__suggest')]")
    private WebElement popupResultSuggestions;

    @FindBy(xpath = "//*[contains(@class,'v-icon sprite-shared v-icon v-icon__cart')]")
    private WebElement addToCardButton;

    @FindBy(xpath = "//div[contains(@class,'4470358')]//button")
    private WebElement addToCardPhoneButton;

    @FindBy(xpath = "//span[contains(@class,'cart__count')]")
    private WebElement amountOfGoodsInTheCardSpan;

    @FindBy(xpath = "//div[contains(@class,'theme')]//div[@class='draggable']")
    private WebElement switcherThemeHeader;

    @FindBy(xpath = "//div[contains(@class,'language')]//div[@class='draggable']")
    private WebElement switcherLanguageHeader;

    @FindBy(xpath = "//body[contains(@class,'white')]")
    private WebElement bodyHeader;

    @FindBy(xpath = "html[1]")
    private WebElement mainPageHtml;

    @FindBy(xpath = "//a[contains(@class,'color-selection__link')]")
    private List<WebElement> selectedColorLinks;

    @FindBy(xpath = "//div[contains(@class,'sort-by__')]")
    private WebElement blockSortProductsItem;

    @FindBy(xpath="//ul[contains(@class,'sort')]/li[1]")
    private WebElement optionSortByAscending;

    @FindBy(xpath="//ul[contains(@class,'sort')]/li[2]")
    private WebElement optionSortByDescending;

    public HomePage open() {
        getWebDriver().get(getUrl());
        return this;
    }

    public void clickSelectedColorLink(){
        selectedColorLinks.stream().filter(link->link.getAttribute("href").contains("a12-3-32gb-black-sm")).findFirst().get().click();
    }
    public String getColorHeader() {
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOf(bodyHeader));
        return Color.fromString(bodyHeader.getCssValue("background-color")).asHex();

    }

    public String getLanguageOfPage() {
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.urlToBe("https://allo.ua/"));
        return mainPageHtml.getAttribute("lang");
    }

    public HomePage setTextToSearchInput(String text) {
        searchInput.sendKeys(text);
        searchInput.click();
        return this;
    }

    public HomePage clickResultLink() {
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOfAllElements(popupResultSuggestions));
        searchResultsLinks.stream().findFirst().ifPresent(WebElement::click);
        WaitUtils.waitForPageLoad(getWebDriver());
        return this;
    }

    public HomePage clickAddToCardButton() {
        addToCardButton.click();
        return this;
    }

    public HomePage clickSwitcherThemeHeader() {
        switcherThemeHeader.click();
        return this;
    }

    public HomePage clickSwitcherLanguageHeader() {
        switcherLanguageHeader.click();
        return this;
    }

    public HomePage clickAddToCardPhoneButton() {
        addToCardPhoneButton.click();
        return this;
    }

    public HomePage clickSortProductsByDescending(){
        Actions action = new Actions(getWebDriver());
        action.moveToElement(blockSortProductsItem).moveToElement(optionSortByDescending).click().build().perform();
        WaitUtils.explicitWait(getWebDriver(),ExpectedConditions.urlContains("order-price"));
        return this;
    }

    public HomePage clickSortProductsByAscending(){
        Actions action = new Actions(getWebDriver());
        action.moveToElement(blockSortProductsItem).moveToElement(optionSortByAscending).click().build().perform();
        WaitUtils.explicitWait(getWebDriver(),ExpectedConditions.urlContains("order-price"));
        return this;
    }
    public String getAmountOfGoodsInTheCardText() {
        return amountOfGoodsInTheCardSpan.getText();
    }
}
