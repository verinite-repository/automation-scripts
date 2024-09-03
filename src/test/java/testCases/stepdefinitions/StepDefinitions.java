package testCases.stepdefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import pages.demosite.DemoLoginScreen;
import pages.demosite.Screen;

public class StepDefinitions extends UIInteractions {

    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    PropertyFileReader prop = new PropertyFileReader("src/test/resources/config.properties");

    @Steps
    Screen screen;

    @Given("{} is on {} page")
    public void userIsOnUrlPage(String user, String url) {
        System.out.println("parameters: " + user + ", " + url);
        screen.open(elementType, elementKey);
    }

    @When("he views the value in the field {}")
    public void heViewsTheValueInTheFieldXpath(String xPath) {
        System.out.println("parameters: " + xPath);
    }

    @Then("he should be able to view {} in the field")
    public void heShouldBeAbleToViewDataInTheField(String data) {
        System.out.println("parameters: " + data);
        wait.until(ExpectedConditions.titleContains(data));
        logger.info("Page title contains: {}", data);
        if (driver != null) {
            driver.quit();
        }
    }

    @When("he enters the value {} in the field with a path {}")
    public void heEntersTheValueDataInTheFieldWithAPathXpath(String data, String xPath) {
        System.out.println("parameters: " + data + ", " + xPath);
    }

    @When("he enters the value {} in the field identified by {}")
    public void heEntersTheValueDataInTheFieldIdentifiedByElementId(String data, String elementId) {
        System.out.println("parameters: " + data + ", " + elementId);
    }

    @When("he enters the value {} in the field named {}")
    public void heEntersTheValueDataInTheFieldNamedElementName(String data, String elementName) {
        System.out.println("parameters: " + data + ", " + elementName);
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementName)));
        searchBox.clear();
        searchBox.sendKeys(data);
    }

    @When("he clicks the button identified by {}")
    public void heClicksTheButtonIdentifiedByButtonId(String buttonId) {
        System.out.println("parameters: " + buttonId);
    }

    @When("he clicks the button named {}")
    public void heClicksTheButtonNamedButtonName(String buttonName) {
        System.out.println("parameters: " + buttonName);
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name(buttonName)));
        searchButton.click();
        logger.info("Clicked the button: {}", buttonName);
    }

    @When("he clicks the element identified by {}")
    public void heClicksTheElementIdentifiedByElementId(String elementId) {
        System.out.println("parameters: " + elementId);
    }
}
