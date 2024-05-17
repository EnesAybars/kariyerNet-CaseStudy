package net.kariyer.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.kariyer.pages.ForgotMyPasswordPage;
import net.kariyer.pages.LoginPage;
import net.kariyer.utilities.ConfigurationReader;
import org.junit.Assert;

public class ForgotMyPassStepDef {

    private LoginPage loginPage = new LoginPage();
    private ForgotMyPasswordPage forgotMyPassPage = new ForgotMyPasswordPage();



    //Step-1
    @Given("user on the login page")
    public void user_on_the_login_page() {
        loginPage.goLoginPage();
        forgotMyPassPage.adayUyeGirisTitle.isDisplayed();
        String actualPageText = forgotMyPassPage.adayUyeGirisTitle.getText();
        //String expectedPageText = ConfigurationReader.get("loginTitle");
        String expectedPageText = "Aday Üye Girişi";
        /* Since the charset doesn't support "ş" letter, I embedded the loginTitle as static in the above statement.
        See in the configuration.properties when you hover-over the letter: "Unsupported characters for the charset
        'ISO-8859-1'" */
        Assert.assertEquals(expectedPageText, actualPageText);
    }

    @When("user click I Forgot My Password link")
    public void user_click_I_forgot_my_password_link() {
        loginPage.forgottonPassLink.click();
    }

    @Then("user should on I forgot my password page")
    public void user_should_on_I_forgot_my_password_page() {
        forgotMyPassPage.sifremiUnuttumTitle.isDisplayed();
        String actualPageText = forgotMyPassPage.sifremiUnuttumTitle.getText();
        //String expectedPageText = ConfigurationReader.get("forgotMyPassPageTitle");
        String expectedPageText = "Şifremi Unuttum"; //Static code bcz of: "Ş" letter
        Assert.assertEquals(expectedPageText, actualPageText);
    }


    //Step-1 forgotMYPass with email
    @When("user clicks email button")
    public void user_clicks_email_button() {
        forgotMyPassPage.emailButton.click();
    }

    @When("user enters emailEmail")
    public void user_enters_emailEmail() {
        forgotMyPassPage.emailInputForEmail.sendKeys(ConfigurationReader.get("username"));
    }

    @When("user clicks send button for email")
    public void user_clicks_send_button_for_email() {
            forgotMyPassPage.submitButton.click();
    }

    @Then("user should see reset link sent page")
    public void user_should_see_reset_link_sent_page() {
        Assert.assertTrue(forgotMyPassPage.sifreSifirBagGonderdikText.isDisplayed());
        String actualTitle = forgotMyPassPage.sifreSifirBagGonderdikText.getText();
        String expectedTitle = "Şifre sıfırlama bağlantısını gönderdik";  //Static code bcz of: "Ş" letter
        Assert.assertEquals(expectedTitle, actualTitle);
    }



    //Step-2 forgotMYPass with phoneNumber
    @When("user clicks phone button")
    public void userClicksPhoneButton() {
        forgotMyPassPage.telephoneButton.click();
    }

    @And("user enters emailPhone")
    public void userEntersEmailPhone() {
        forgotMyPassPage.emailInputForPhone.sendKeys(ConfigurationReader.get("username"));
    }

    @And("user enters lastName")
    public void userEntersLastName() {
        forgotMyPassPage.lastNameInput.sendKeys(ConfigurationReader.get("lastName"));
    }

    @And("user enter phoneNumber")
    public void userEnterPhoneNumber() {
        forgotMyPassPage.phoneInput.sendKeys(ConfigurationReader.get("phoneNum"));
    }

    @When("user clicks send button for phone")
    public void user_clicks_send_button_for_phone() {
        forgotMyPassPage.submitButton.click();
        if (forgotMyPassPage.errorMessagePopUp.isDisplayed()){
            Assert.fail();
        }else{
            Assert.assertTrue(true);
        }

    }

}
