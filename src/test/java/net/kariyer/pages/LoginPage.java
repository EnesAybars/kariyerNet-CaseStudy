package net.kariyer.pages;

import net.kariyer.utilities.ConfigurationReader;
import net.kariyer.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]")
    public WebElement captchaHeader;

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

    public void waitForCaptcha(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.titleIs(ConfigurationReader.get("accountPageTitle")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
