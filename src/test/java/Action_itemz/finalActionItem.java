package Action_itemz;

import Reusable_Libary.Abstract_Class_Cross_Browser;
import Reusable_Libary.ReuseableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class finalActionItem extends Abstract_Class_Cross_Browser {
    @Test
    public void Fed_ex() throws InterruptedException{
        logger.log(LogStatus.INFO,"Navigating to fedex page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        ReuseableMethods_Loggers.click(driver,"//*[@data-analytics='hdr|tab|3|design & print']",logger,"click Design");
        Thread.sleep(1900);
        ReuseableMethods_Loggers.click(driver,"//*[@href='https://www.fedex.com/apps/printonline/#!']",logger,"click upload link");
        Thread.sleep(1500);
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Fedex Office Print")) {
            logger.log(LogStatus.PASS,"you got the right " + actualTitle);

        }else {
            logger.log(LogStatus.FAIL,"you is wrong " + actualTitle);
        }//end of try

        Thread.sleep(4700);
        ReuseableMethods_Loggers.click(driver,"//*[@title='Document Printing']",logger,"Click Doc print");
        Thread.sleep(1000);
        ReuseableMethods_Loggers.click(driver,"//*[@title='Get Started - Copies & Custom Projects']",logger,"click custom projects");
        Thread.sleep(2000);
        ReuseableMethods_Loggers.click(driver,"//*[@name='upload-files-button']",logger,"Click upload button");
        Thread.sleep(2200);
        ReuseableMethods_Loggers.uploadFile("C:\\Users\\sabbi\\OneDrive\\Desktop\\Maven_Automation_java\\src\\main\\resources\\QApic.jpg");
        Thread.sleep(5100);
        ReuseableMethods_Loggers.click(driver,"//*[@id='js-modal__continue-btn_lowResolutionPreview']",logger,"Continue with existing");
        Thread.sleep(5000);
        ReuseableMethods_Loggers.sendKeys(driver,"//*[@id='item-quantity']","5",logger,"Quantity");
        Thread.sleep(2100);
        ReuseableMethods_Loggers.click(driver,"//*[contains(@name,'update_quanity-addToCart')]",logger,"Add to cart");
        Thread.sleep(2200);
        try {
            ReuseableMethods_Loggers.mouseClick(driver,"//*[@alt='close']",logger,"Pop up cancel");
            Thread.sleep(2000);

        } catch (Exception err) {
            System.out.println("pop up does not show " + err);
        }//end of catch

        ReuseableMethods_Loggers.click(driver,"//*[@id='cartToCheckoutBtn']",logger,"CheckOut");
        Thread.sleep(1900);
        ReuseableMethods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"Continue as Guest");
        Thread.sleep(1900);
        ReuseableMethods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"Miles");
        Thread.sleep(2000);
        ReuseableMethods_Loggers.typeAndSubmit(driver,"//*[@id='loc_seacrh_text']",logger,"11225","My Zipcode");
        Thread.sleep(2000);
        String ActiveAddress = ReuseableMethods_Loggers.captureResult(driver, "//*[@class='active']", logger, "Capturing suggested address");
        Thread.sleep(2000);
        System.out.println(ActiveAddress);













    }//end test








}//end of class
