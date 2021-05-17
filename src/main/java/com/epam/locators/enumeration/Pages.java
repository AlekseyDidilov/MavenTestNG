package com.epam.locators.enumeration;

import com.epam.locators.pages.*;

public enum Pages {
   HOME(HomePage.class),
   RESULT_OF_SEARCH(ResultPage.class),
   CARD(CardPage.class),
    MAIN_INFO_ABOUT_PRODUCT(MainInfoAboutProductPage.class);



    private Class<? extends BasePage> clazz;

    Pages(Class<? extends BasePage> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends BasePage> getClazz() {
        return clazz;
    }

    public static Pages byType(Class<? extends BasePage> clz) {
        for (Pages item : Pages.values()) {
            if (item.getClazz().getSimpleName().equalsIgnoreCase(clz.getSimpleName())) {
                return item;
            } else {
                continue;
            }
        }
        return null;
    }
}
