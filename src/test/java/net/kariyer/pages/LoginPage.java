package net.kariyer.pages;

import net.kariyer.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/p")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//a[@id='forgottenPassLink']")
    public WebElement forgottonPassLink;


    /*
    @FindBy(xpath = "//h3[@class='login-title']")
    public WebElement adayUyeGirisTitle;
     */

    public void goForgotMyPassPage() {
        driver.get(ConfigurationReader.get("url"));
        girisYapUyeOlButton.click();
        adayGirisiButton.click();
        forgottonPassLink.click();
    }

    public void goLoginPage(){
        driver.get(ConfigurationReader.get("url"));
        girisYapUyeOlButton.click();
        adayGirisiButton.click();
    }



}
