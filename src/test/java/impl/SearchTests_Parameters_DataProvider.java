package impl;

import api.BaseTest;
import com.epam.locators.config.WebDriverConfiguration;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchTests_Parameters_DataProvider extends BaseTest {

    private String searchWord;
    public static final String PATH_TO_DATA_FILE = "src/test/resources/searchWords.data";

    @DataProvider(name = "searchWords")
    public static Object[] searchWords() {
        return new Object[]{"lg", "apple", "red"};
    }

    public SearchTests_Parameters_DataProvider(String searchWord) {
        this.searchWord = searchWord;
    }

    @DataProvider(name = "loadSearchWordsFromFile")
    public static Object[] loadSearchWordsFromFile() throws IOException {
        List<String> searchWordsList = new ArrayList<>();
        try (Scanner text = new Scanner(new File(PATH_TO_DATA_FILE ))) {
            while (text.hasNext()) {
                String print = text.nextLine();
                searchWordsList.add(print);
            }
        }
        return searchWordsList.toArray();
    }

    @Test(dataProvider = "searchWords")
    public void SearchResultItemsContainSearchWord(String searchWord) {
        storage.getPage(HomePage.class)
                .open()
                .setTextToSearchInput(searchWord)
                .clickResultLink();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkSearchWordsInResults(searchWord));
    }

    @Test
    @Parameters({ "param"})
    public void SearchResultItemsContainSearchWord1(String searchWord) {
        storage.getPage(HomePage.class)
                .open()
                .setTextToSearchInput(searchWord)
                .clickResultLink();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkSearchWordsInResults(searchWord));
    }

    //added to show violation of the Liskov substitution principle - for current tests we don't need clear cookies, but can broke other tests and  violate the Liskov substitution principle
    @Override
    @AfterClass
    public void tearDown() {
        WebDriverConfiguration.tearDown();
    }
}
