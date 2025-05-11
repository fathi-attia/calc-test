package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  Signup_Login_page extends Page_Base {

    // عناصر الصفحة (locators)
    By name_field = By.name("name");
    By email_field = By.cssSelector("input[data-qa='signup-email']");
    By signup_button = By.cssSelector("button[data-qa='signup-button']");
    By login_mail=By.cssSelector("input[data-qa='login-email']");
    By login_pass=By.cssSelector("input[data-qa='login-password']");
    By login_button=By.cssSelector(("button[data-qa='login-button']"));
    public Signup_Login_page(WebDriver driver) {
        super(driver);
    }

    // الميثود الخاصة بإدخال الاسم
    public void enter_name(String name) {
        Enter_text(name_field, name);
    }

    // الميثود الخاصة بإدخال الإيميل
    public void enter_email(String email) {
        Enter_text(email_field, email);
    }

    // الميثود الخاصة بالضغط على زر التسجيل
    public void click_signup_button() {
        Clk_Button(signup_button);
    }
    public void login(String mail,String pass){
        Enter_text(login_mail,mail);
        Enter_text(login_pass,pass);


    }
    public void login_click()
    {
        Clk_Button(login_button);
    }
}
