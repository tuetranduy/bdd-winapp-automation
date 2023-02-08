package org.tuetd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.tuetd.managers.DriverManager;
import org.tuetd.utils.ClickUtils;
import org.tuetd.utils.VisibilityUtils;

public class BasePage {

    public BasePage() {
        initializePageElements();
    }

    private void initializePageElements() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public BasePage click(WebElement element, String errorMessage) {
        waitUntilVisible(element, errorMessage);
        waitUntilClickable(element, errorMessage);
        ClickUtils.click(getClass(), element, errorMessage);
        return this;
    }

    public void waitUntilVisible(WebElement element, String errorMessage) {
        VisibilityUtils.waitUntilVisible(getClass(), element, errorMessage);
    }

    public BasePage waitUntilClickable(WebElement element, String errorMessage) {
        ClickUtils.waitUntilClickable(getClass(), element, errorMessage);
        return this;
    }

    public BasePage waitUntilClickable(By locator, String errorMessage) {
        ClickUtils.waitUntilClickable(getClass(), locator, errorMessage);
        return this;
    }
}
