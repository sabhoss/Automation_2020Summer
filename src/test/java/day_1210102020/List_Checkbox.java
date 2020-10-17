package day_1210102020;

import Reusable_Libary.Reusable_Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_Checkbox {
 @Test
    public void verifications() throws InterruptedException {

     WebDriver driver = Reusable_Method.getDriver();
     driver.navigate().to("https://www.yahoo.com");
     Thread.sleep(2000);
     //get the count of all links on yahoo home page
     List<WebElement> AmountofLInks = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
     //printout the link count
     System.out.println("Link count is " + AmountofLInks.size());

     //click on sign in button
     Reusable_Method.click(driver,"//*[@class='_yb_687jt']","Sign in button");
     Thread.sleep(2500);
     boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
     //expecting the checkbox to be selected
     if(checkboxState == true){
         System.out.println("Checkbox is selected as expected");
     } else {
         System.out.println("Checkbox is not selected by default");
     }//end of if else









    }//END OF TEST










}//end of class
