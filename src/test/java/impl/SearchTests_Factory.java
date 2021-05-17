package impl;

import api.BaseTest;
import com.epam.locators.config.WaitConfiguration;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class SearchTests_Factory extends BaseTest {

    private String searchWord;

    public SearchTests_Factory(String searchWord) {
        this.searchWord = searchWord;
    }

    @Test
    public void SearchResultItemsContainSearchWord1() {

        storage.getPage(HomePage.class)
                .open()
                .setTextToSearchInput(searchWord)
                .clickResultLink();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkSearchWordsInResults(searchWord));
    }
}