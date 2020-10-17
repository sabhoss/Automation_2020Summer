package Action_itemz;

import Reusable_Libary.Reusable_Method;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class actionitemz6 {


    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_Method.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItemz.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItemz_Results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite

    @Test
    public void getTotalPay() throws WriteException, InterruptedException {
        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String Airport = writableSheet.getCell(0, i).getContents();
            String StartDate = writableSheet.getCell(1, i).getContents();
            String StartTime = writableSheet.getCell(2, i).getContents();
            String EndDate = writableSheet.getCell(3, i).getContents();
            String EndTime = writableSheet.getCell(4, i).getContents();
            String VehicleSize = writableSheet.getCell(5, i).getContents();
            //delete cookies
            driver.manage().deleteAllCookies();
            //navigate to mortgage home
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            //click on airport search bar
            Reusable_Method.click(driver, "//*[contains(@id,'pickup-display')]", "Pick up Location");
            Reusable_Method.typeAndSubmit(driver, "//*[@name='pickup']",Airport,"Airport");
           //click on airport name
            Reusable_Method.click(driver,"//*[contains(@class='smarty-item-icon')]","Choose Airport Link");

            Thread.sleep(2000);
            //line below is clicking on calendar icon first for start date
            Reusable_Method.mouseClick(driver,"//*[contains(@id,'dateRangeInput-display-start-inner')]","StartDate click");
             //enter start date
            Reusable_Method.typeAndSubmit(driver,"//*[contains(@id,'pickup-date-input')]",StartDate,"StartDate enter");
            //close the calender by clicking on something do title search for hundred
            Reusable_Method.mouseClick(driver,"//*[@class='title dark']","Dark Title");
         //put like 1 second
            Thread.sleep(1000);
            //click start time icon
            Reusable_Method.mouseClick(driver,"//*[contains(@id,'start-time-select-display')]","Start Time");
            Thread.sleep(2500);
            //click on start time value
            Reusable_Method.mouseClick(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+StartTime+"']","Start Time Value");
            //line below is clicking on calendar icon first for end date
            Reusable_Method.click(driver,"//*[contains(@id,'dateRangeInput-display-end')]","EndDate click");
            //enter end date
            Reusable_Method.typeAndSubmit(driver,"//*[contains(@id,'dropoff-date-input')]",EndDate,"EndDate enter");
            //click title to close calender
            Reusable_Method.click(driver,"//*[@class='title dark']","Dark Title");
            Thread.sleep(1000);
            //click end time icon
            Reusable_Method.mouseClick(driver,"//*[contains(@id,'end-time-select-display-status')]","Start Time");
            Thread.sleep(2500);
            //click on start time value
            Reusable_Method.mouseClick(driver,"//*[contains(@id,'end-time-select-option') and @data-title='"+EndTime+"']","End Time Value");
            Thread.sleep(2000);
            //press search button
            Reusable_Method.mouseClick(driver,"//*[@class='v-c-p centre ']","search button");
            //click on small
            Reusable_Method.mouseClick(driver,"//*[contains(@class='MPti-Title' and text()='"+VehicleSize+"')]","small button");

            //click third link
            Reusable_Method.clickByIndex(driver,"//*[contains(@id,'providerSelect_')]",2,"third link");
            //need to store get window handles command in as ArrayList to switch to different tab(S)
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            //capture total due //class='fpiCell',class='sc-VJcYb drkFuw' class="sc-VJcYb drkFuw"
            String result = Reusable_Method.Capture(driver, "//*[@class='fpiCell' or @class='sc-VJcYb drkFuw']", "Total Due");
            System.out.println("My Total Due is " + result);
            //store and send it to the empty column in excel writable file
            Label label = new Label(6, i, result);
            //adding this label to the writable sheet
            writableSheet.addCell(label);


        }//end of for loop

    }//end of test

    @AfterSuite
    public void closingInformation() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();

    }//end of aftersuite


    }//end of java class
