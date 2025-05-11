
package test;
import org.example.pages.Home_Page;

import org.example.pages.Signup_Login_page;
import org.example.pages.Signup_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class User_Register extends Test_Base
{


    Home_Page homePageObject;
    Signup_Login_page signupLoginPageObject;
    Signup_Page signupPageobject;

    String expecedvalue="fathi";


    @Test
    public void run_test() throws InterruptedException {

        // إنشاء كائن من الصفحة الرئيسية
        homePageObject = new Home_Page(driver);
        homePageObject.click_signup_login_button();
        // لاحظ تصحيح اسم الميثود (بداية بفعل)

        // إنشاء كائن من صفحة تسجيل الدخول/التسجيل
        signupLoginPageObject = new Signup_Login_page(driver);
        signupLoginPageObject.enter_name("fathi");
        signupLoginPageObject.enter_email("f3@f.aa");
        signupLoginPageObject.click_signup_button();

        signupPageobject =new Signup_Page(driver);
        signupPageobject.selectGender("f");
        signupPageobject.enter_pass("P@ssww0rd");
        signupPageobject.select_date("22","10","2018");
        signupPageobject.enter_name("fathi","attia");
        signupPageobject.enter_address("sharjah");
        signupPageobject.enter_country("Canada");
        signupPageobject.enter_location_details("ca","canada","123");
        signupPageobject.enter_mobile("0559272097");
        signupPageobject.submit();


        // لاحظ تصحيح اسم الميثود هنا أيضًا
       // Assert.assertTrue(driver.findElement(By.cssSelector("input[data-qa='name']")).isDisplayed());
     //   String actualValue = driver.findElement(By.cssSelector("input[data-qa='name']")).getAttribute("value");
       // Assert.assertEquals(actualValue,expecedvalue, "القيمة غير مطابقة!");


    }
}
