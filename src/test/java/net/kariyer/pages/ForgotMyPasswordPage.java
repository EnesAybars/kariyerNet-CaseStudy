package net.kariyer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotMyPasswordPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div[1]/button[1]")
    public WebElement emailButton; //on the forgotMyPass page

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div[1]/button[2]")
    public WebElement telephoneButton; //on the forgotMyPass page

    @FindBy(xpath = "//h1[.='Şifre sıfırlama bağlantısını gönderdik']")
    public WebElement sifreSifirBagGonderdikText;

    @FindBy(xpath = "//h3[@class='login-title']")
    public WebElement adayUyeGirisTitle;

    @FindBy(xpath = "//h1")
    public WebElement sifremiUnuttumTitle;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInputForEmail;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement emailInputForPhone;


    @FindBy(xpath = "//button[@class='submit-button']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[3]/div[1]/div/div/div/div/div")
    public WebElement errorMessagePopUp;




}

