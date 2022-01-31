package class2;
/*
TC 2: HRMS Application Negative Login:
Open chrome browser
Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void Login(){
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        String actualErrMsg= driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
        String expectedErrMsg="Password cannot be empty";
        Assert.assertEquals(actualErrMsg,expectedErrMsg);
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
    }