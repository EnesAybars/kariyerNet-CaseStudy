package net.kariyer.pages;

import net.kariyer.utilities.BrowserUtils;
import net.kariyer.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

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

    public void accountPageVerification(){
        try {
            //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            //wait.until(ExpectedConditions.visibilityOf(guideFrame));
            //skipGuideButton.click();

            //wait.until(ExpectedConditions.visibilityOf(closeAdvertiseButton));
            //closeAdvertiseButton.click();

            //wait.until(ExpectedConditions.visibilityOf(emailText));

            BrowserUtils.wait(3);

            String actualMail = emailText.getText();
            String expectedMail = ConfigurationReader.get("username");
            Assert.assertEquals(expectedMail, actualMail);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accountPageAssertion(String expected){
        String actual = ConfigurationReader.get("accountPageTitle");
        Assert.assertEquals(expected, actual);
    }



}
