package net.kariyer.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.kariyer.pages.AccountPage;
import net.kariyer.pages.LoginPage;
import net.kariyer.utilities.BrowserUtils;
import net.kariyer.utilities.ConfigurationReader;
import net.kariyer.utilities.Driver;
import org.junit.Assert;

public class LoginStepDefinitions {

    private LoginPage loginPage = new LoginPage();

    private AccountPage accountPage = new AccountPage();

    /**
     * Positive Case
     * */
    // Step1
    @Given("user on the home page")
    public void user_on_the_home_page() {
        loginPage.goBasePage();
    }
    @When("user clicks the girisYap button")
    public void user_clicks_the_girisYap_button() {
        loginPage.girisYapUyeOlButton.click();
    }
    @When("user clicks the adaygiris button")
    public void user_clicks_the_adaygiris_button() {
        loginPage.adayGirisiButton.click();
    }
    @Then("user should be on the login page")
    public void user_should_be_on_the_login_page() {
        String expectedTitle = ConfigurationReader.get("loginPageTitle");
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user enters username")
    public void user_enters_username() {
        loginPage.username.sendKeys(ConfigurationReader.get("username"));
    }
    @When("user enters password")
    public void user_enters_password() {
        loginPage.password.sendKeys(ConfigurationReader.get("password"));
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.girisYapButton.click();
        BrowserUtils.wait(3);
        loginPage.waitForCaptcha();
        /*
        Puzzle captcha works in this step which fails the test, so that I skipped this part manually.
        In order to pass this step, we have to slide the captcha manually, so that we need time.
        Therefore, I wait with Java logic which is not recommended for real work environment.
        */

    }

    @Then("user should be on the account page")
    public void user_should_be_on_the_account_page() {

        /**
         * Solution 1
         * */
        //accountPage.accountPageVerification();

        /* In this step Scenario works as it must be. User can land the accountPage. However, we get
        NullPointerException in this solution because of the guideFrame. There is something wrong with
        finding the web element which seems in the DOM but when we locate it, it doesn't response as WebElement.
        Therefore, it throws NullPointerException.
        */
        /**
        * IMPORTANT NOTE!!!
        * I realized that I forgot to add implicitlyWait into my driver. Due to synchronization issue, my code
        * throws NullPointerException when we try to run accountPageVerification method. After I add implicitly
        * wait into my driver class, and wait with explicitly with the methods created, we can see
        * that the Scenario is passing from test execution and working properly. WebDriver remains synchronized
        * with the actual page.
        *
        */



        /**
         * Solution 2
         * */

         accountPage.accountPageAssertion(Driver.getDriver().getTitle());
    }

}
