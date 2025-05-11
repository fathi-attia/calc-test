package test;


import org.example.pages.Home_Page;
import org.example.pages.Signup_Login_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
public class test_calc extends Test_Base {
    Home_Page homePageObject;

    @Test
    public void run_calc() throws InterruptedException {
        homePageObject = new Home_Page(driver);
        homePageObject.enter_calc_no("30", "10");
        homePageObject.press_add();
        Thread.sleep(100);
        homePageObject.press_sub();
        Thread.sleep(100);
        homePageObject.press_multi();
    }
}



