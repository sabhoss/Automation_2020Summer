package Action_itemz;

import Reusable_Libary.Abstract_Class;
import Reusable_Libary.ReuseableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InclassActionitem_2 extends Abstract_Class {
    @Test
            public void Yahoo_search() throws InterruptedException {

        logger.log(LogStatus.INFO, "Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        //verify title using soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "yahoo");

        //get the count of all links on yahoo home page
        List<WebElement> AmountofLInks = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));
        //printout the link count
        System.out.println("Link count is " + AmountofLInks.size());
        Thread.sleep(1000);
        ReuseableMethods_Loggers.typeAndSubmit(driver,"//*[@class='_yb_1a8w9']",logger,"Nutrition","search bar");
        Thread.sleep(2000);
        //need to scroll to the bottom of the page to capture the search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll down using executeScript command
        jse.executeScript("scroll(0,5000)");
        //capture the entire footer including the result from the yahoo result page
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        //need to split by Next to separate the search result
        String[] arrayResult = result.split("Next");
        //need to split again to only catch number
        String[] searchResult = arrayResult[1].split(" ");
        //print out the number you are looking for
        Thread.sleep(1000);

        //need to scroll to the bottom of the page to capture the search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll down using executeScript command
        jse.executeScript("scroll(0,-5000)");
        Thread.sleep(1000);
        ReuseableMethods_Loggers.click(driver,"//*[@class='fl-l mr-5 last']",logger,"Images");
        Thread.sleep(1000);
        //get the count of all links on yahoo home page
        List<WebElement> AmountofLInkz = driver.findElements(By.xpath("//*[contains(@id='yui_3_5_1_1']"));
        //printout the link count
        System.out.println("Link count is " + AmountofLInkz.size());
        Thread.sleep(1000);
        ReuseableMethods_Loggers.click(driver,"//*[@class='text signin']",logger,"sign in");
        Thread.sleep(1000);
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        if(checkboxState == true){
            System.out.println("Checkbox is selected as expected");
        } else {
            System.out.println("Checkbox is not selected by default");
        }//end of if else
        ReuseableMethods_Loggers.sendKeys(driver,"//*[@class='login-username']","WeweWawa69",logger,"enter Fake username");
        Thread.sleep(1000);
        ReuseableMethods_Loggers.click(driver,"//*[id='login-signin']",logger,"Sign in");

















    }//end of test
}//end class
