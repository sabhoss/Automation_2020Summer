package Day_809262020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class InclassActionItem {

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




            driver.navigate().to("https://www.hotels.com");
            //navigate to hotels.com
            Thread.sleep(2000);
            //2 second delay
          //destination
            try {
                System.out.println("enter on destination search bar");
             WebElement destination = driver.findElement(By.xpath("//*[@name='q-destination']"));
             destination.sendKeys("Tokyo, Japan");
            } catch (Exception err) {
                System.out.println("unable to to click on destination" + err);
            }//end of click destanation exeption
            //clicking on destination search bar
            Thread.sleep(1000);
            //delay 1 sec

            //click on first link

                 try{
                     System.out.println("Click on first link");
                    driver.findElement(By.xpath("//*[@class='autosuggest-category-result']")).click();

                   Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click first destination " + err);
                }//end of link destination

        //CheckIn
        try
        {
            System.out.println("Entering a new date on check in:");
            WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));
            checkIn.clear();
            Thread.sleep(2000);
            checkIn.sendKeys("10/28/20");
            Thread.sleep(2000);

        } catch (Exception err)
        {
            System.out.println("Unable to enter a new date on check in " + err);
        }

        //CheckOut
        try
        {
            System.out.println("Entering a new date on check out:");
            WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));
            checkIn.clear();
            Thread.sleep(2000);
            checkIn.sendKeys("11/03/20");
            Thread.sleep(2000);

        } catch (Exception err)
        {
            System.out.println("Unable to enter a new date on check out " + err);
        }

        //Rooms
        try{
            System.out.println("Selecting number of rooms");
            WebElement Room1 = driver.findElement(By.xpath("//*[@id='qf-0q-rooms']"));
            Select roomList = new Select(Room1);
            Thread.sleep(2000);
            roomList.selectByVisibleText("1");
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println("Unable to select number of rooms" + err);
        }

        //Adults
        try{
            System.out.println("Selecting number of adults");
            WebElement Adults = driver.findElement(By.xpath("//*[@id='qf-0q-room-0-adults']"));
            Select roomList = new Select(Adults);
            Thread.sleep(2000);
            roomList.selectByVisibleText("6");
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println("Unable to select number of adults " + err);
        }//

        //Search
        driver.findElement(By.xpath("//*[@class='cta cta-strong']")).click();
        Thread.sleep(5000);

          //click first link
        try {
            System.out.println("Click the first link");
            driver.findElement(By.xpath("//*[@class='p-name']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click link");
        }//end of first link exception

        //need to store get window handles command in as ArrayList to switch to different tab(S)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));
        //capture result
        try {
            System.out.println("capture name of resort");
            String resortName = driver.findElement(By.xpath("//*[@class='vcard']")).getText();
            //String[] onlyResortName = resortName.split(" ");
            System.out.println(resortName);
        } catch (Exception err) {
            System.out.println("Unable to Capture the name of the resort " + err);
        }//end of exception






        Thread.sleep(5000);
        //driver.close();



/*
                try {
                    System.out.println("Click on third link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                    Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click third link " + err);
                }//end of link 2
            }//end of if condition


                try {
                    System.out.println("Click on first link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                    Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click first link " + err);
                }//end of link 3


            try {
                String name = driver.findElements(By.xpath("//*[@class='locationName-1jro_']")).get(0).getText();
                System.out.println(name);
            } catch (Exception err) {
                System.out.println("Unable to capture NAME text " + err);
            }//end of string exception
            //get full address
            try {
                String address = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                String address1 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                System.out.println(address + address1);

            } catch (Exception err) {
                System.out.println("Unable to capture address text " + err);
            }//end of exception



            //need to scroll to the bottom of the page to capture the chart
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down using executeScript command
            jse.executeScript("scroll(0,500)");
           /*try {
                driver.findElement(By.xpath("//*[text()='Atlantic City, New Jersey, United States of America']")).click();
                //click on recomendation Atlantic city using TEXT

            } catch (Exception err)
            System.out.println("Unable to click on recomendation");

            try {
                driver.findElement(By.xpath())
            }
*/









    }//end of method


}//end of java class
