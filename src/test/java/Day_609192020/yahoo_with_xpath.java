package Day_609192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_xpath {
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

        //type a key word on yahoo search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        //click submit on search button
        driver.findElement(By.xpath("//*[@value='Search']")).click();
        //delay 2 to 3 seconds
        Thread.sleep(2500);
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











    }//end of method



}//end of class

