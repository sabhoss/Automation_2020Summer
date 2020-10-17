package Day_509132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_options {

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

        //navigate to google page
        System.out.println("navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //delay of 2 seconds
        Thread.sleep(2000);

        //capture the home page title and verify it matches the expected title
        //which is GOOGLE






    }//end of main method

}//end of java class

