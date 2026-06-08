package testCases.stepdefinitions;

// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utils.PropertyFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import pages.demosite.Screen;

public class StepDefinitions extends UIInteractions {

    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    PropertyFileReader prop = new PropertyFileReader("src/test/resources/config.properties");

    @Steps
    Screen screen;

    @Given("{} is on {} page")
    public void userIsOnUrlPage(String user, String url) {
        System.out.println("parameters: " + user + ", " + url);
        screen.open(user, url);
    }

    @When("he views the value in the field {}")
    public void heViewsTheValueInTheFieldXpath(String xPath) {
        System.out.println("parameters: " + xPath);
        screen.view(xPath);
    }

    @Then("he should be able to view {} in the field")
    public void heShouldBeAbleToViewDataInTheField(String data) {
        System.out.println("parameters: " + data);
        screen.view(data);
    }

    @When("he enters the value {} in the field with a path {}")
    public void heEntersTheValueDataInTheFieldWithAPathXpath(String data, String xPath) {
        System.out.println("parameters: " + data + ", " + xPath);
        screen.update(data, "xpath", xPath);
    }

    @When("he enters the value {} in the field identified by {}")
    public void heEntersTheValueDataInTheFieldIdentifiedByElementId(String data, String elementId) {
        System.out.println("parameters: " + data + ", " + elementId);
        screen.update(data, "id", elementId);
    }

    @When("he enters the value {} in the field named {}")
    public void heEntersTheValueDataInTheFieldNamedElementName(String data, String elementName) {
        System.out.println("parameters: " + data + ", " + elementName);
        screen.update(data, "name", elementName);
    }

//    @When("he clicks the button identified by {}")
//    public void heClicksTheButtonIdentifiedByButtonId(String buttonId) {
//        System.out.println("parameters: " + buttonId);
//        screen.click("id", buttonId);
//    }

    @When("he clicks the button identified by xpath {}")
    public void heClicksTheButtonIdentifiedByXpathButtonXpath(String buttonXpath) {
        System.out.println("parameters: " + buttonXpath);
        screen.click("xpath", buttonXpath);
    }

//    @When("he clicks the button identified by xpath {}")
//    public void heClicksTheButtonIdentifiedByXpathButtonXpath(String buttonXpath) {
//        System.out.println("parameters: " + buttonXpath);
//        screen.click("xpath", buttonXpath);
//    }

    @When("he clicks the button named {}")
    public void heClicksTheButtonNamedButtonName(String buttonName) {
        System.out.println("parameters: " + buttonName);
        screen.click("name", buttonName);
    }

    @When("he clicks the element identified by {}")
    public void heClicksTheElementIdentifiedByElementId(String elementId) {
        System.out.println("parameters: " + elementId);
    }

    @Then("he should see the text {} in the element identified by xpath {}")
    public void validateTextByXpath(String expectedText,
                                    String xpath) {
        assertTrue(
                screen.validateText(
                        expectedText,
                        "xpath",
                        xpath));
    }

    @Then("he should see the value {} in the field named {}")
    public void validateValueByName(String expectedValue,
                                    String fieldName) {
        assertTrue(
                screen.validateValue(
                        expectedValue,
                        "name",
                        fieldName));
    }

    @Then("the element identified by xpath {} should be displayed")
    public void elementShouldBeDisplayed(String xpath) {
        assertTrue(
                screen.isDisplayed(
                        "xpath",
                        xpath));
    }

    @Then("the element identified by xpath {} should be enabled")
    public void elementShouldBeEnabled(String xpath) {
        assertTrue(
                screen.isEnabled(
                        "xpath",
                        xpath));
    }

    @Then("he should see result {} under element {}")
    public void validateNestedResult(String expectedResult,
                                    String xpath) {
        assertTrue(
                screen.validateNestedText(
                        expectedResult,
                        "xpath",
                        xpath));
    }

    @Then("he should be able to view {} in element {} having attribute {}")
    public void validateAttribute(String expectedValue,
                                String xpath, String attribute) {
        assertTrue(
                screen.validateAttribute(
                        expectedValue,
                        attribute,
                        "xpath",
                        xpath));
    }
}