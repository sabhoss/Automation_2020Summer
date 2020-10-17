package Reusable_Libary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;

public class Reusable_Method {

    public static WebDriver getDriver(){

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

        return driver;


    }//end of driver



   //reusable method to click on any element on any websites
    public static void click(WebDriver driver, String locator, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method

        //reusable method to submit on element on any websites
        public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName){
            //define explicit wait
            WebDriverWait wait = new WebDriverWait(driver,10);
            try{
                System.out.println("Typing on element " + elementName);
           WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userValue);
            } catch(Exception err){
                System.out.println("Unable to type on element " + err);
            }//end of exception


    }//end of sendkeys method

    //reusable method to submit on any element and any websites
    public static void submit(WebDriver driver, String locator, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            System.out.println("Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        }catch (Exception err){
            System.out.println("Unable to submit on element " + err);
        }//end of exception
    }//end of submit method

    //reusable method to capture on any element and any websites
    public static String Capture (WebDriver driver, String locator, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        String Texts = "" ;
        try {
            System.out.println("Capturing " + elementName);
            Texts = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(Texts);
        }catch (Exception err){
            System.out.println("Unable to Capture " + err);
        }//end of exception
        return Texts;
    }//end of capture method

    //reusable method to dropdown on element on any websites
    public static void DropDown(WebDriver driver, String locator, String userValue, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Select dropdown on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select DropDown = new Select(element);
            DropDown.selectByVisibleText(userValue);
        } catch (Exception err) {
            System.out.println("Unable to Select dropdown on element " + err);
        }//end of exception

    }//end of dropdown method
    public static void typeAndSubmit(WebDriver driver,String locator, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,3);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }
    }//end of type and submit method

    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click by index method

    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,3);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }
    }//end of click method


    }//end of class
