import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@Suite
@IncludeEngines("cucumber")
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "testCases.stepdefinitions",
        plugin = {"pretty"},
        monochrome = true
)

@SelectClasspathResource("/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,timeline:build/test-results/timeline")
public class CucumberTestSuite {
   /* @Rule
    public JiraTicketonFailure jireTicketonFailure = new JiraTicketonFailure();*/

     /* @AfterClass
    public static void afterClass()
    {
        //Storage s=new Storage();
   Map<String, String> str=   Storage.getScenarioStatuses();
      for (Map.Entry<String, String> set : str.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
          if (set.getValue().equalsIgnoreCase("Failed")) {
             // fail();
              fail("create ticket");
          } else {
              System.out.println("Passed");
          }
        }

        System.out.println("-----------------------After CLASS-------------------------------------");
    }*/


}
