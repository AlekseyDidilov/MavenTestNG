package impl;

import org.testng.annotations.Factory;

public class SimpleTestFactory
{
    private final String APPLE = "apple";
    private final String SAMSUNG = "samsung";

    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new SearchTests_Factory(APPLE), new SearchTests_Factory(SAMSUNG) };
    }
}