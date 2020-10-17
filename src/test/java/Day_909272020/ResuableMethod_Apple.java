package Day_909272020;

import Reusable_Libary.Reusable_Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ResuableMethod_Apple {
    public static void main(String[] args) {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");


        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        driver.navigate().to("https://www.apple.com");

        //calling the reusable click method for clicking on mac link
        Reusable_Method.click(driver,"//*[@data-analytics-title='mac']","Mac Link");
        //click on mac book air
        Reusable_Method.click(driver,"//*[text()='MacBook Air']", "Mac Book Air");


    }//end of method
}//end of class
