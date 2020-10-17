package Action_itemz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_item3 {
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
        String[] hobbies = new String[5];
        hobbies[0] = "scrapbooking";
        hobbies[1] = "dancing";
        hobbies[2] = "singing";
        hobbies[3] = "skydiving";
        hobbies[4] = "larping";

        for(int i = 0; i < hobbies.length; i++){   //explain this to me? //i less
            //lets navigate to google home page
            driver.navigate().to("https://www.bing.com");
            //maximize my window
            //driver.manage().window().maximize();
            //put two second delay
            Thread.sleep(2000);
            //locate search field by name and enter a keyword on the field
            driver.findElement(By.name("q")).sendKeys(hobbies[i]); //does this mean your telling intellij to type the names?
            //close driver
            //driver.close();
            //quit entire session
            //driver.quit();
            //click on google search
            //driver.findElement(By.name("btnK")).click().
            Thread.sleep(2000);
            //Handling delay using sleep command
            driver.findElement(By.id("sb_form_go")).submit();
            Thread.sleep(2000);
            String result = driver.findElement(By.className("sb_count")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("My search number is " + hobbies[i]+ " is " + arrayResult[0]);



        }//end of for loop

        driver.quit();



    }//end of method




}//end of class
