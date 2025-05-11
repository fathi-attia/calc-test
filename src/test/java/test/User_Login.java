package test;

import org.example.pages.Home_Page;
import org.example.pages.Signup_Login_page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class User_Login extends Test_Base {

    Signup_Login_page loginPage;
    Home_Page homePageObject;



    @Test
    public void login_with_new_user() {
        homePageObject = new Home_Page(driver);
        homePageObject.click_signup_login_button();
        loginPage = new Signup_Login_page(driver);

        loginPage.login("f3@f.aa","P@ssww0rd");
        loginPage.login_click();

        // Assert that user is logged in successfully
    //    Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed());
    }
}
