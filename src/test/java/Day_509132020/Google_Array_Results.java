package Day_509132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Array_Results {
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

        //lets create dynamic array to handle multiple boroughs on google search
        String[] boroughs = new String[5];
        boroughs[0] = "Brooklyn";
        boroughs[1] = "Queens";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Bronx";
        boroughs[4] = "Staten Island";

        for(int i = 0; i < boroughs.length; i++){
            //lets navigate to google home page
            driver.navigate().to("https://www.google.com");
            //maximize my window
            //driver.manage().window().maximize();
            //put two second delay
            Thread.sleep(2000);
            //locate search field by name and enter a keyword on the field
            driver.findElement(By.name("q")).sendKeys(boroughs[i]);
            //close driver
            //driver.close();
            //quit entire session
            //driver.quit();
            //click on google search
            //driver.findElement(By.name("btnK")).click().
            Thread.sleep(2000);
            //Handling delay using sleep command
            driver.findElement(By.name("btnK")).submit();
            String result = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("My search number is " + boroughs[i]+ " is " + arrayResult[1]);



        }//end of for loop

        driver.quit();



    }//end of method




}//end of class
