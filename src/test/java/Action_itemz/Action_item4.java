package Action_itemz;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.ArrayList;
import java.util.List;


public class Action_item4 {

    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        //set the driver to be incognito
        options.addArguments("incognito");
        //run the driver in headless mode
        options.addArguments("headless");


        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        ArrayList<String> zipCodeList = new ArrayList<>();
        zipCodeList.add("11234");
        zipCodeList.add("11235");
        zipCodeList.add("11237");

        driver.navigate().to("https://www.weightwatchers.com");
        String title = driver.getTitle();
        System.out.println("Actual title is " + title);


        for (int i = 0; i < zipCodeList.size(); i++) {


            //go to website
            driver.navigate().to("https://www.weightwatchers.com");
            //delay 2 seconds
            Thread.sleep(2000);
            //click on find workshop
            try {
                System.out.println("clicking on workshop");
                driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();

            } catch (Exception err) {
                System.out.println("Unable to click on workshop " + err);
            }//end of workshop exception

            Thread.sleep(2000);

            //entering a zipcode
            try {
                System.out.println("entering zipcode");
                WebElement zip = driver.findElement(By.xpath("//*[@id='location-search']"));
                zip.clear();
                zip.sendKeys(zipCodeList.get(i));
                zip.submit();

            } catch (Exception err) {
                System.out.println("Unable to enter value on zipcode " + err);
            }//end of zipcode exception
            Thread.sleep(2000);

            //click on second link
            if (i == 0) {
                try {

                    System.out.println("Click on second link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();

                    Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click second link " + err);
                }//end of link
            }//end of if condition

            if (i == 1) {
                try {
                    System.out.println("Click on third link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                    Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click third link " + err);
                }//end of link 2
            }//end of if condition

            if (i == 2) {
                try {
                    System.out.println("Click on first link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                    Thread.sleep(2000);
                } catch (Exception err) {
                    System.out.println("Unable to Click first link " + err);
                }//end of link 3
            }//end of if condition

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
        try {
// if you multiple elements is you need get.gettext to specify which 1 you want

            String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
            System.out.println(schedule);
        } catch (Exception err) {
            System.out.println("Unable to hours of operation and schedule " + err);


            }//end of exception

        }// end of for loop

        driver.quit();






















        }//end of main method

    }//end of class


