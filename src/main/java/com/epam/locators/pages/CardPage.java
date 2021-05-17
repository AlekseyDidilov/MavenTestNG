package com.epam.locators.pages;

import com.epam.locators.utils.WaitUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class CardPage extends BasePage {
    public CardPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @Override
    public String getUrl() {
        return null;
    }

    @FindBy(xpath = "//button[@class='comeback']")
    private WebElement comebackToGoodsButton;

    @FindBy(xpath = "//button[@class='order-now']")
    private WebElement checkoutOrderButton;

    @FindBy(xpath = "//span[contains(@class,'header-title')]")
    private WebElement headerTitleCardPopupSpan;

    @FindBy(xpath = "//div[contains(@class,'close-btn')]")
    private WebElement closeIcon;

    @FindBy(xpath = "//span[contains(@class,'__price')]")
    private WebElement priceText;

    public CardPage clickComebackButton() {
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOfAllElements(comebackToGoodsButton));
        comebackToGoodsButton.click();
        return this;
    }

    public boolean HeaderTitleCardIsDisplayed() {
        return headerTitleCardPopupSpan.isDisplayed();
    }

    public boolean checkoutOrderButtonIsDisplayed() {
        WaitUtils.explicitWait(getWebDriver(),ExpectedConditions.visibilityOf(checkoutOrderButton));
        return checkoutOrderButton.isDisplayed();
    }

    public boolean comebackToGoodsButtonIsDisplayed() {
        return comebackToGoodsButton.isDisplayed();
    }

    public boolean closeIconIsDisplayed(){
        return closeIcon.isDisplayed();
    }
    public boolean priceTextIsDisplayed(){
        return priceText.isDisplayed();
    }
}
