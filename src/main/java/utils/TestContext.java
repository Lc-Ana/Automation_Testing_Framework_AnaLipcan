package utils;

import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;

    public TestContext(){
        webDriverManager = new WebDriverManager("chrome");
    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }
}
