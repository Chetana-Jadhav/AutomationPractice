package PageObjectModel;

import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.TestContext;

@Log4j2 @Getter @Setter
public class SignUp_Page_Objects  {

    TestContext testContext;
    public SignUp_Page_Objects(TestContext testContext) {
        this.testContext = testContext;
    }


    private By signUpLink = By.xpath("//a[@class='login']");
    private By emailAddress = By.id("email_create");
    private By createAccButton = By.id("SubmitCreate");
    private By title = By.xpath("//input[@id='id_gender1']");
    private By day = By.xpath("//select[@id='days']");
    private By month = By.xpath("//select[@id='months']");
    private By year = By.xpath("//select[@id='years']");
    private By state = By.xpath("//select[@id='id_state']");
    private By country = By.xpath("//select[@id='id_country']");
    private By register = By.xpath("//button[@id='submitAccount']");
    private By Welcomemsg = By.xpath("//p[text()='Welcome to your account. Here you can manage all of your personal information and orders.']");
    private By EmailAdd = By.xpath("//input[@id='email']");
    private By pswd = By.xpath("//input[@id='passwd']");
    private By SignIn = By.xpath("//button[@id='SubmitLogin']");
    private By ForgotPassword = By.partialLinkText("Forgot your password?");


    public void user_clicked_on_sign_in_link_and_entered_email_as(String email) {
        testContext.getDriver().findElement(signUpLink).click();
        testContext.getDriver().findElement(emailAddress).sendKeys(email);
        log.debug("Email entered as  " + email);
    }

    public void user_clicked_on_create_an_account_button() {
        testContext.getDriver().findElement(createAccButton).click();
        log.debug("Create an account button clicked");
    }

    public void selectTitle() {
        testContext.getDriver().findElement(title).click();
    }

    public void SelectDateOfBirth() {
        Select Day = new Select(testContext.getDriver().findElement(day));
        Day.selectByValue("5");
        Select Month = new Select(testContext.getDriver().findElement(month));
        Month.selectByValue("5");
        Select Year = new Select(testContext.getDriver().findElement(year));
        Year.selectByValue("1995");
    }

    public void SelectState() {
        Select State = new Select(testContext.getDriver().findElement(state));
        State.selectByValue("30");
    }

    public void SelectCountry() {
        Select Country = new Select(testContext.getDriver().findElement(country));
        Country.selectByValue("21");
    }

    public void ClickOnRegisterButton() {
        testContext.getDriver().findElement(register).click();
        log.debug("Register button clicked");
    }

    public void validateAccountGeneration() {
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(expectedTitle, testContext.getDriver().getTitle());
        boolean expectedMsg = testContext.getDriver().findElement(Welcomemsg).isDisplayed();
        Assert.assertEquals(expectedMsg, true);
        log.debug("Account created. success message validated");
    }

    public void user_is_logged_in_with_email_as_and_password_as(String Email, String password) {
        testContext.getDriver().findElement(signUpLink).click();
        testContext.getDriver().findElement(EmailAdd).sendKeys(Email);
        log.debug("Email entered as: " + Email);
        testContext.getDriver().findElement(pswd).sendKeys(password);
        log.debug("Password entered as: " + password);
        testContext.getDriver().findElement(SignIn).click();
    }
}

