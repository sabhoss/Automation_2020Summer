package Day_1310112020;

import Reusable_Libary.Abstract_Class;
import Reusable_Libary.ReuseableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Google_Search_Abstract extends Abstract_Class {

    @Test
    public void Google_Search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        ReuseableMethods_Loggers.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        Thread.sleep(2000);
    }//end of test 123

    @Test(dependsOnMethods = "Google_Search")
    public void Google_Search_Result() throws InterruptedException {
        String result = ReuseableMethods_Loggers.captureResult(driver,"//*[@id='result-stats']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[1]);
        //after all the test steps per @Test you must end the test as well
    }//end of test




}//end of class
