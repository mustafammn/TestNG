package class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {

    @BeforeMethod
    public void before(){
        System.out.println("Before method");
    }
    @AfterMethod
    public void after(){
        System.out.println("After method");
    }
    @Test
    public void balance(){
        System.out.println("Your balance is 25$");
    }
    @Test
    public void Deposit(){
        System.out.println("You successfully deposited 5$");
    }
    @Test
    public void Withdraw(){
        System.out.println("You successfully withdraw 3$");
    }
}
