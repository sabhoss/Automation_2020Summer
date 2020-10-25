package Cucumber_Framework.step_Definitions;

import Reusable_Libary.Abstract_Class_Cucumber;
import Reusable_Libary.Abstract_Class;
import Reusable_Libary.Abstract_Class_Cucumber;
import Reusable_Libary.ReuseableMethods_Loggers;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Google_Search_Result extends Abstract_Class_Cucumber {

    @Test(priority = 1)
    @Given("^I navigate to Google homepage$")
    public void navigateToGoogleHome() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
    }//end of navigate

    @Test(dependsOnMethods = "navigateToGoogleHome")
    @When("^I enter a keyword on search field$")
    public void googleSearchField() {
        ReuseableMethods_Loggers.sendKeys(driver, "//*[@name='q']", "cars", logger, "Search Field");
    }//end of search field

    @Test(dependsOnMethods = "googleSearchField")
    @When("^I click on Search button$")
    public void googleSubmitButton() {
        ReuseableMethods_Loggers.submit(driver, "//*[@name='btnK']", logger, "Search Field");
    }//end of submit button

}