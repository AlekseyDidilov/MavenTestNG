package com.epam.locators.utils;

import com.epam.locators.enumeration.Pages;
import com.epam.locators.pages.*;


import java.util.HashMap;
import java.util.Map;

public class PageStorage {

    Map<Pages, BasePage> pages = new HashMap<>();

    public PageStorage() {
        pages.put(Pages.HOME, new HomePage());
        pages.put(Pages.RESULT_OF_SEARCH,new ResultPage());
        pages.put(Pages.CARD,new CardPage());
        pages.put(Pages.MAIN_INFO_ABOUT_PRODUCT,new MainInfoAboutProductPage());


    }

    @SuppressWarnings("unchecked")
    public <T extends BasePage> T getPage(Class<T> clazz) {
        Pages page = Pages.byType(clazz);
        return clazz.cast(pages.get(page));
    }
}