package Action_itemz;

import Reusable_Libary.Reusable_Method;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_item5 {

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
//create array list
        ArrayList<String> firstname = new ArrayList<>();
        firstname.add("Johnny");
        firstname.add("Tony");
        firstname.add("Barry");

        ArrayList<String> lastname = new ArrayList<>();
        lastname.add("Robbie");
        lastname.add("Papi");
        lastname.add("Mama");


        ArrayList<String> month = new ArrayList<>();
        month.add("June");
        month.add("May");
        month.add("July");

        ArrayList<String> day = new ArrayList<>();
        day.add("12");
        day.add("11");
        day.add("10");

        ArrayList<String> year = new ArrayList<>();
        year.add("1966");
        year.add("1969");
        year.add("1976");

        ArrayList<String> SSN = new ArrayList<>();
        SSN.add("111222");
        SSN.add("111224");
        SSN.add("111265");


        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11223");
        zipcode.add("11224");
        zipcode.add("11225");
        //for loop

        for(int i = 0; i < firstname.size(); i++) {

            //navigate to uhc.com
            driver.navigate().to("https://www.UHC.com");
            //click on find a doctor link
            Reusable_Method.click(driver, "//*[@aria-label='Find a Doctor']", "Find a Doctor");
            //click on find a provider
            Reusable_Method.click(driver, "//*[@id='btn-sign-in']", "Find a Provider");

            //need to store get window handles command in as ArrayList to switch to different tab(S)
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));

            //click on register now
            Reusable_Method.click(driver, "//*[@id='registerbutton']", "Register Button");
            //id='piFirstName'

            //enter firstname
            Reusable_Method.sendKeys(driver,"//*[@id='firstName']",firstname.get(i),"First Name Field");

            //enter last name
            Reusable_Method.sendKeys(driver,"//*[@id='lastName']",lastname.get(i),"First Name Field");

            //click month
            Reusable_Method.click(driver, "//*[@id='dob_month_input']", "month Field");

            //select month
            Reusable_Method.DropDown(driver,"//*[@id='dob_month_input']",month.get(i),"month Field");
            //id='dob_month_input'

            //enter day
            Reusable_Method.sendKeys(driver,"//*[@id='dob_day']",day.get(i),"Day Field");

            //enter year
            Reusable_Method.sendKeys(driver,"//*[@id='dob_year']",year.get(i),"Year Field");

            //click no
            Reusable_Method.click(driver, "//*[@id='ssn_container']", "SSN button Field");

            //enter social
            Reusable_Method.sendKeys(driver,"//*[@id='ssnLastSixDigits']",SSN.get(i),"SSN Field");

            //enter zip
            Reusable_Method.sendKeys(driver,"//*[@id='zipCode']",zipcode.get(i),"zipcode Field");
             //click continue
            Reusable_Method.click(driver, "//*[@id='submitBtn']", "Continue Field");
            //capture error
            Reusable_Method.Capture(driver,"//*[@class='ErrorContent--3ZzRv']","Error Field");
               //close window
            driver.close();
            //switch back to previous tab
            driver.switchTo().window(tabs.get(0));
            //renavigate back to UHC
            driver.navigate().to("https://www.UHC.com");








        }// end of loop










    }//end of method

}// end of class