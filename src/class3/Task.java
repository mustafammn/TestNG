package class3;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import utils.CommonMethods;

import java.io.File;
import java.io.IOException;

/*
TC 1: HRMS Add Employee:
Open chrome browser
Go to HRMS
Login into the application
Add 5 different Employees and create login credentials by providing:
First Name
Last Name
Username
Password
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
 */
public class Task extends CommonMethods {

    private Files FileUtils;

    @DataProvider
    public Object[][] employee(){
        Object[][] addEmployee= new Object[6][5];
        addEmployee[0][0]="AbdulHamidd";
        addEmployee[0][1]="Ahmadii";
        addEmployee[0][2]="ahmadihamid1";
        addEmployee[0][3]="ADdffg@12311!";
        addEmployee[0][4]="ADdffg@12311!";

        addEmployee[1][0]="Ramin";
        addEmployee[1][1]="Amin";
        addEmployee[1][2]="aminramin";
        addEmployee[1][3]="AFkjsfh@314!";
        addEmployee[1][4]="AFkjsfh@314!";

        addEmployee[2][0]="Azim";
        addEmployee[2][1]="Wardak";
        addEmployee[2][2]="azimwardak";
        addEmployee[2][3]="FSAF!12431@";
        addEmployee[2][4]="FSAF!12431@";

        addEmployee[3][0]="Mustafa";
        addEmployee[3][1]="Hashimi";
        addEmployee[3][2]="hashimimustafa";
        addEmployee[3][3]="FGAgf#12133!";
        addEmployee[3][4]="FGAgf#12133!";

        addEmployee[4][0]="Khaled";
        addEmployee[4][1]="Noorzai";
        addEmployee[4][2]="noorzaikhaled";
        addEmployee[4][3]="DFgfg!@sdf12";
        addEmployee[4][4]="DFgfg!@sdf12";

        addEmployee[5][0]="Jamshed";
        addEmployee[5][1]="Azada";
        addEmployee[5][2]="azadajamshed";
        addEmployee[5][3]="JHasd@11!@13";
        addEmployee[5][4]="JHasd@11!@13";

        return addEmployee;
    }

    @Test(groups="regression", dataProvider = "employee")
    public void NewEmployee(String firstname, String lastname, String username, String password, String confirmPassword) throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstname);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastname);
        driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"re_password\"]")).sendKeys(confirmPassword);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
    }


}
