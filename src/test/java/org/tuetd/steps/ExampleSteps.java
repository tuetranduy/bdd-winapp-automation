package org.tuetd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.tuetd.pages.ExamplePage;

public class ExampleSteps {

    @Given("Press one")
    public void pressOne() {
        ExamplePage examplePage = new ExamplePage();

        examplePage.pressOne();
    }

    @When("Press Plus")
    public void pressPlus() {
        ExamplePage examplePage = new ExamplePage();

        examplePage.pressPlus();
    }

    @And("Press Two")
    public void pressTwo() {
        ExamplePage examplePage = new ExamplePage();

        examplePage.pressTwo();
    }

    @Then("^Result should be (.*)$")
    public void verifyImageShowedUp(String result) {
        ExamplePage examplePage = new ExamplePage();

        examplePage.pressEquals();

        Assert.assertEquals(result, examplePage.getResult());
    }

    @Given("Click Practice Name input")
    public void clickPracticeName() {
        ExamplePage examplePage = new ExamplePage();

        examplePage.clickPracticeNameInput();
    }

    @When("^Enter '(.*)' to Practice Name input$")
    public void enterToPracticeName(String input) {
        ExamplePage examplePage = new ExamplePage();

        examplePage.enterTextToPracticeNameInput(input);

    }

}
