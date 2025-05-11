package org.example.pages;

import org.checkerframework.checker.optional.qual.OptionalBottom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup_Page extends Page_Base{
    public Signup_Page(WebDriver driver) {
        super(driver);
    }



    By genderRadioButtonMale   = By.id("id_gender1");
    By genderRadioButtonFemale = By.id("id_gender2");

    By passwordField           = By.cssSelector("input[data-qa='password']");
    By dayDropdown             = By.cssSelector("select[data-qa='days']");
    By monthDropdown           = By.cssSelector("select[data-qa='months']");
    By yearDropdown            = By.cssSelector("select[data-qa='years']");

    By firstNameField          = By.cssSelector("input[data-qa='first_name']");
    By lastNameField           = By.cssSelector("input[data-qa='last_name']");
    By addressField            = By.cssSelector("input[data-qa='address']");
    By countryDropdown         =By.cssSelector(("select[data-qa='country']"));
    By stateField              = By.cssSelector("input[data-qa='state']");
    By cityField               = By.cssSelector("input[data-qa='city']");
    By zipcodeField = By.cssSelector("input[data-qa='zipcode']");
    By mobileField              = By.cssSelector("input[data-qa='mobile_number']");
    By creatButton             =By.cssSelector(("button[data-qa='create-account']"));




    public void selectGender(  String gender) {
        if (gender.equalsIgnoreCase("m")) {
            Clk_Button(genderRadioButtonMale);
        } else if (gender.equalsIgnoreCase("f")) {
            Clk_Button(genderRadioButtonFemale);
        }
    }
    public void enter_pass(String password){
        Enter_text(passwordField,password);
    }
    public void select_date(String day,String month,String year)
    {
        select_By_value(dayDropdown,day);
        select_By_value(monthDropdown,month);
        select_By_value(yearDropdown,year);


    }
public void enter_name(String firstName, String lastNme)
{

    Enter_text(firstNameField,firstName);
    Enter_text(lastNameField,lastNme);

}
    public void enter_address(String address)
    {

        Enter_text(addressField,address);

    }

    public void enter_country(String country)
    {
    select_By_value(countryDropdown,country);
    }
    public void enter_location_details(String state,String city,String zip)
    {
        Enter_text(stateField,state);
        Enter_text(cityField,city);
        Enter_text(zipcodeField,zip);

    }
    public void enter_mobile(String mobile)
    {
        Enter_text(mobileField,mobile);
    }
    public void submit() throws InterruptedException {
        Thread.sleep(100);
        wait(creatButton,10);
        Clk_Button(creatButton);
    }
}
