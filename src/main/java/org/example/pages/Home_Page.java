package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page extends Page_Base {
    //calc
    By add_button =By.cssSelector(("button[data-qa='btn-add']"));
    By sub_button=By.cssSelector(("button[data-qa='btn-subtract']"));
    By multi_button=By.cssSelector(("button[data-qa='btn-multiply']"));
    By input1=By.cssSelector("input[data-qa='input-num1']");
    By input2=By.cssSelector("input[data-qa='input-num2']");
    // تعريف عنصر زر التسجيل/الدخول
    By signup_login_button = By.cssSelector("a i.fa-lock");

    public Home_Page(WebDriver driver) {
        super(driver);
    }

    // المُنشئ (constructor)
    public void enter_calc_no(String no1,String no2)
    {
        wait(input1,10);
        Enter_text(input1,no1);
        Enter_text(input2,no2);

    }
    public void press_add(){
        Clk_Button(add_button);
    }
    public void press_sub(){
        Clk_Button(sub_button);
    }
    public void press_multi(){
        Clk_Button(multi_button);
    }
    // الضغط على زر التسجيل/الدخول
    public void click_signup_login_button() {
        // استخدام انتظار قبل الضغط
        wait(signup_login_button,10);
        Clk_Button(signup_login_button);
    }
}
