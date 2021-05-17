package com.epam.locators.pages;


import com.epam.locators.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainInfoAboutProductPage extends BasePage {
    @Override
    public String getUrl() {
        return null;
    }

    public MainInfoAboutProductPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//li[contains(@class,'colors')]/a")
    private List<WebElement> colorsOfProductLinks;

    @FindBy(xpath = "//h3[contains(@class,'title')]/span")
    private List<WebElement> colorTitle;

    @FindBy(xpath = "//h1[contains(@class,'title')]")
    private WebElement descriptionTitleText;


    public boolean checkColorsProduct() {
        WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOfAllElements(colorsOfProductLinks));
       String txt =colorsOfProductLinks.get(0).getText();
        String nfm=colorTitle.get(0).getText();
        String sdbvcmsn=descriptionTitleText.getText();
       if (!(colorsOfProductLinks.get(0).getText().contains(colorTitle.get(0).getText()) && descriptionTitleText.getText().contains(colorTitle.get(0).getText()))) {
            return false;
        }
        for (int i = 1; i < colorsOfProductLinks.size(); i++) {
            colorsOfProductLinks.get(i).click();
            WaitUtils.explicitWait(getWebDriver(), ExpectedConditions.visibilityOfAllElements(colorsOfProductLinks));
            if (!(colorsOfProductLinks.get(i).getText().contains(colorTitle.get(0).getText()) && descriptionTitleText.getText().contains(colorTitle.get(0).getText()))) {
                return false;
            }
        }
        return true;
    }


}
