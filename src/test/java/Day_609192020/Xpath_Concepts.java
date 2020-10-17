package Day_609192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.print.DocFlavor;

public class Xpath_Concepts {

    public static void main(String[] args) throws InterruptedException {

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

        //navigate to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        //delay 2 seconds
        Thread.sleep(2000);
        //locate search field by id or name
        driver.findElement(By.xpath("//*[contains(@id,'ybar-sbq') or @name='p']")).sendKeys("cars");

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        //delay 2 seconds
        Thread.sleep(2000);
        //using contain only specify matching word within a property to locate an element
        driver.findElements(By.xpath("//*[contains(@class,'_yb_ypcmj ')]")).get(2).click();

    }//end of method

}//end of class

