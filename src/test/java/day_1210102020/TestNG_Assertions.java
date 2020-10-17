package day_1210102020;

import Reusable_Libary.Reusable_Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {

 @Test
    public void assertions() throws InterruptedException {

     WebDriver driver = Reusable_Method.getDriver();

     driver.navigate().to("https://www.google.com");

     Thread.sleep(2000);

     //verify the google title using hard assert
     //Assert.assertEquals("GOOGLE",driver.getTitle());

     //verify title using soft assertion
     SoftAssert softAssert = new SoftAssert();
     softAssert.assertEquals(driver.getTitle(), "GOOGLE");

     //enter a keyword on search
     Reusable_Method.sendKeys(driver, "//*[@name='q']", "cars", "search field");

     softAssert.assertAll(); //to store all errors coming from soft assert
 }//end of test















}//end of class
