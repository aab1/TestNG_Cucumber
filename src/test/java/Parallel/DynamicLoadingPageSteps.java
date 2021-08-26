package Parallel;

import com.pages.herokapp.BaseClass_AvailableExamples;
import com.pages.herokapp.DynamicLoadingPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class DynamicLoadingPageSteps {
    private ConfigReader configReader;
    Properties prop;
    BaseClass_AvailableExamples baseClass_availableExamples = new BaseClass_AvailableExamples(DriverFactory.getDriver());
    DynamicLoadingPage dynamicLoadingPage;

    @Given("user is on the internet herokapp examples page")
    public void user_is_on_the_internet_herokapp_examples_page() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        DriverFactory.getDriver().get(prop.getProperty("herokuappUrl"));
    }

    @When("user clicks on {string} from herokapp examples page")
    public void user_clicks_on_from_herokapp_examples_page(String linkText) throws Exception {
        dynamicLoadingPage = baseClass_availableExamples.clickDynamicLoading(linkText);
    }

    @Then("The Dynamically Loaded Page Elements is displayed")
    public void the_dynamically_loaded_page_elements_is_displayed() {
        Assert.assertEquals(dynamicLoadingPage.getPageTitle(), "The Internet");
    }

    @When("User clicks on example one and start")
    public void user_clicks_on_example_one_and_start() throws Exception {
        dynamicLoadingPage.clickExampleOne();
        dynamicLoadingPage.clickStartButton();
    }

    @Then("{string} is displayed on the Dynamically Loaded Page")
    public void is_displayed_on_the_dynamically_loaded_page(String expectedText) throws Exception {
        Assert.assertEquals(dynamicLoadingPage.getHelloWorldText(),expectedText);
    }

}
