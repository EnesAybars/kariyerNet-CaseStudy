package net.kariyer.pages;

import net.kariyer.utilities.ConfigurationReader;
import net.kariyer.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"navbar-wrapper\"]/nav/div/ul[2]/li[2]/button/span")
    public WebElement girisYapUyeOlButton;

    @FindBy(xpath = "//*[@id='login-buttons-wrapper']/a[1]")
    public WebElement adayGirisiButton;

    public void goBasePage() {
        driver.get(ConfigurationReader.get("url"));
    }








}
