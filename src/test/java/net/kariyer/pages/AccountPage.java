package net.kariyer.pages;

import net.kariyer.utilities.ConfigurationReader;
import net.kariyer.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    //@FindBy(xpath = "//span[.='ibars.practice@gmail.com']")
    @FindBy(xpath = "//*[@id=\"header-section\"]/div[2]/div[2]/div/span")
    public WebElement emailText;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[4]/div[2]/button[1]")
    public WebElement skipGuideButton;

    @FindBy(xpath = "//div[@class='k-guide']")
    public WebElement guideFrame;

    @FindBy(xpath = "//button[@class='close']")
    public WebElement closeAdvertiseButton;

    @FindBy(xpath = "//body[@class]")
    public WebElement pageBody;


    /*
    LoginStepDefinitions, Step: @Then->user should be on the account page
    Here at below statement, another solution perspective for Verification of account page landing;
    We can skip any pop-ups opening, locate any webElement and then Assert if it is visible or clickable.
     */
    public void accountPageVerification(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(guideFrame));
            skipGuideButton.click();

            wait.until(ExpectedConditions.visibilityOf(closeAdvertiseButton));
            closeAdvertiseButton.click();

            wait.until(ExpectedConditions.visibilityOf(emailText));

            String actualMail = emailText.getText();
            String expectedMail = ConfigurationReader.get("username");
            Assert.assertEquals(expectedMail, actualMail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
