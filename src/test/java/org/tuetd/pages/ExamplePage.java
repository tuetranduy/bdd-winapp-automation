package org.tuetd.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tuetd.managers.DriverManager;

public class ExamplePage extends BasePage {

    @FindBy(name = "Clear")
    WebElement clear;

    @FindBy(name = "One")
    WebElement one;

    @FindBy(name = "Two")
    WebElement two;

    @FindBy(name = "Plus")
    WebElement plus;

    @FindBy(name = "Equals")
    WebElement equals;

    public void pressOne() {
        click(one, "Unable to press 1");
    }

    public void pressTwo() {
        click(two, "Unable to press 2");
    }

    public void pressPlus() {
        click(plus, "Unable to press plus");
    }

    public void pressEquals() {
        click(equals, "Unable to press equal");
    }

    public String getResult() {
        WebElement calculatorResult = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("CalculatorResults"));
        return calculatorResult.getText().replace("Display is", "").trim();
    }
}
