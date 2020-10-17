package Action_itemz;

import Reusable_Libary.Abstract_Class;
import Reusable_Libary.ReuseableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionItemz7 extends Abstract_Class {

    @Test
    public void Express_Search() throws InterruptedException, IOException, BiffException, WriteException {

        Workbook readableFile;
        Sheet readableSheet;
        WritableWorkbook writableFile;
        WritableSheet writableSheet;
        int rowCount;

        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItemday13z.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItemday13z_results.xls"), readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        for (int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipcode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvv = writableSheet.getCell(13, i).getContents();
            String confirmemail = writableSheet.getCell(14, i).getContents();

            //delete cookies
            driver.manage().deleteAllCookies();
            logger.log(LogStatus.INFO,"Navigating to express home page");
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2000);
            //hover on mens
            ReuseableMethods_Loggers.mouseHover(driver,"//*[@href='/mens-clothing']",logger,"Hover Mens");
            Thread.sleep(1000);
            //click shirts
            ReuseableMethods_Loggers.mouseClick(driver,"//*[text()='Shirts']",logger,"Click Shirts");
            Thread.sleep(1000);
            ReuseableMethods_Loggers.clickByIndex(driver,"//*[@class='_3TJgM']",2,logger,"click third");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.click(driver,"//*[@value='"+Size+"']",logger,"Size");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.click(driver,"//*[text()='Add to Bag']", logger, "Add to bag");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.mouseHover(driver,"//div[3]/div[1]/button[1]",logger,"hover shopping bag");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.mouseClick(driver,"//*[contains(text(),'View Bag & Check Out')]",logger,"View bag button");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.dropDownMenu(driver,"//*[@id='qdd-0-quantity']",Quantity,logger,"Quantity");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.click(driver,"//*[text()='CheckOut']",logger,"Check Out");
            Thread.sleep(1000);
            ReuseableMethods_Loggers.click(driver,"//*[text()='CheckOut as Guest']",logger,"Continue Guest");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"First name");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger,"last name");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='email']",email,logger,"email");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@aria-label='Confirm Email Address']",confirmemail,logger,"confirm Email");
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger,"phone number");
            ReuseableMethods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC",logger,"click continue");
            Thread.sleep(2000);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger,"addy");
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipcode,logger,"zip");
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"City");
            ReuseableMethods_Loggers.dropDownMenu(driver,"//*[@name='shipping.state']",state,logger,"State");
            ReuseableMethods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"click continue");
            Thread.sleep(2500);
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='creditCardNumber']",cardNumber,logger,"cardnumber");
            ReuseableMethods_Loggers.dropDownMenu(driver,"//*[@name='expMonth']",expMonth,logger,"Expmonth");
            ReuseableMethods_Loggers.dropDownMenu(driver,"//*[@name='expYear']",expYear,logger,"ExpYear");
            ReuseableMethods_Loggers.sendKeys(driver,"//*[@name='cvv']",cvv,logger,"CVV");
            ReuseableMethods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"click continue");
            Thread.sleep(2000);
            String result = ReuseableMethods_Loggers.captureResult(driver,"//*[@id='rvn-note-NaN']",logger,"get result error");
            System.out.println("my error message is " + result);
            //send it to excel empty column
            Label label = new Label(15,i,result);
            //send to writeable sheet

            writableSheet.addCell(label);









        }//end of loop

        writableFile.write();
        writableFile.close();




    }//end of test

}//end of class
