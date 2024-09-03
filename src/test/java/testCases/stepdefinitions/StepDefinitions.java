package testCases.stepdefinitions;

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
    public void userIsOnGoogleUrlPage(String user, String googleUrl) {
        System.out.println("parameters: " + user + ", " + googleUrl);
        screen.open(user, googleUrl);
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
    public void heEntersTheValueDataInTheFieldNamedGooglesearchinput(String data, String googlesearchinput) {
        System.out.println("parameters: " + data + ", " + googlesearchinput);
        screen.update(data, "name", elementName);
    }

    @When("he clicks the button identified by {}")
    public void heClicksTheButtonIdentifiedByButtonId(String buttonId) {
        System.out.println("parameters: " + buttonId);
        screen.click("id", buttonId);
    }

    @When("he clicks the button named {}")
    public void heClicksTheButtonNamedGooglesearchbutton(String googlesearchbutton) {
        System.out.println("parameters: " + googlesearchbutton);
        screen.click("name", buttonName);
    }

    @When("he clicks the element identified by {}")
    public void heClicksTheElementIdentifiedByElementId(String elementId) {
        System.out.println("parameters: " + elementId);
    }
}
