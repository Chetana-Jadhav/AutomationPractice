package StepDefinition;

import PageObjectModel.ProductDetails_Page_Objects;
import PageObjectModel.ShoppingCart_Page_Objects;
import PageObjectModel.SignUp_Page_Objects;
import com.google.inject.Inject;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.NoInjection;
import utils.DriverFactory;
import utils.TestContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Log4j2
public class StepDefs1 {
    String url = "http://automationpractice.com/index.php";
    Scenario scenario;
    TestContext testContext;

    public StepDefs1(TestContext testContext) {
        this.testContext = testContext;
    }


   /* @Before
    public void SetUp(Scenario scenario) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setAcceptInsecureCerts(true);
        // String browserName = System.getProperty("browser");
        testContext.setDriver(DriverFactory.createInstance("chrome"));
        // testContext.setDriver(new ChromeDriver(cap));
        testContext.getDriver().manage().window().maximize();
        testContext.getDriver().manage().deleteAllCookies();
        testContext.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.scenario = scenario;

    }

    */

    @Given("User navigated to {string}")
    public void user_navigated_to(String url) {
        testContext.getDriver().get(url);
        log.debug("Navigated to " + url);
    }

    @When("User clicked on sign in link and entered email as {string}")
    public void user_clicked_on_sign_in_link_and_entered_email_as(String email) {
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.user_clicked_on_sign_in_link_and_entered_email_as(email);

    }

    @When("User clicked on Create an account button")
    public void user_clicked_on_create_an_account_button() {
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.user_clicked_on_create_an_account_button();

    }

    @When("user fill the form with below details")
    public void user_fill_the_form_with_below_details(Map<String, String> userInfo) throws InterruptedException {
        Thread.sleep(2000);
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.selectTitle();
        testContext.getDriver().findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(userInfo.get("FirstName"));
        testContext.getDriver().findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(userInfo.get("LastName"));
        testContext.getDriver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(userInfo.get("Password"));
        SignUpPageObject.SelectDateOfBirth();
        testContext.getDriver().findElement(By.id("company")).sendKeys(userInfo.get("company"));
        testContext.getDriver().findElement(By.id("address1")).sendKeys(userInfo.get("Address"));
        testContext.getDriver().findElement(By.id("address2")).sendKeys(userInfo.get("Address2"));
        testContext.getDriver().findElement(By.id("city")).sendKeys(userInfo.get("city"));
        testContext.getDriver().findElement(By.id("company")).sendKeys(userInfo.get("company"));
        SignUpPageObject.SelectState();
        testContext.getDriver().findElement(By.id("postcode")).sendKeys(userInfo.get("Zipcode"));
        SignUpPageObject.SelectCountry();
        testContext.getDriver().findElement(By.id("other")).sendKeys(userInfo.get("Additional information"));
        testContext.getDriver().findElement(By.id("phone")).sendKeys(userInfo.get("Home Phone"));
        testContext.getDriver().findElement(By.id("phone_mobile")).sendKeys(userInfo.get("Mobile Phone"));
        testContext.getDriver().findElement(By.id("alias")).sendKeys(userInfo.get("Assigned Address"));
        log.debug("Registration form is filled");

    }

    @When("click on Register button")
    public void click_on_register_button() {
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.ClickOnRegisterButton();

    }

    @Then("User account should be created and success message should be given")
    public void user_account_should_be_created_and_success_message_should_be_given() {
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.validateAccountGeneration();

    }

    @Given("user is logged in with email as {string} and password as {string}")
    public void user_is_logged_in_with_email_as_and_password_as(String Email, String password) throws InterruptedException {
        user_navigated_to(url);
        Thread.sleep(2000);
        SignUp_Page_Objects SignUpPageObject = new SignUp_Page_Objects(testContext);
        SignUpPageObject.user_is_logged_in_with_email_as_and_password_as(Email, password);
        Thread.sleep(2000);
    }

    @When("user select product category as T shirts")
    public void user_select_product_category_as_t_shirts() throws InterruptedException {

        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        Thread.sleep(2000);
        ProductPageObject.user_select_product_category_as_t_shirts();

    }

    @When("Click on the product name")
    public void click_on_the_product_name() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.click_on_the_product_name();

    }

    @When("Click on Send to a Friend link, fill the details and click on Send")
    public void click_on_send_to_a_friend_link_fill_the_details_and_click_on_send() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.click_on_send_to_a_friend_link_fill_the_details_and_click_on_send();
    }

    @Then("Message should be appeared that Email sent in a pop up")
    public void message_should_be_appeared_that_email_sent_in_a_pop_up() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.message_should_be_appeared_that_email_sent_in_a_pop_up();
    }

    @When("user click on write review and fill the form")
    public void user_click_on_write_review_and_fill_the_form() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_click_on_write_review_and_fill_the_form();
    }

    @When("user click on send button")
    public void user_click_on_send_button() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_click_on_send_button();
    }

    @Then("Success message should be appeared for new comment")
    public void success_message_should_be_appeared_for_new_comment() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.success_message_should_be_appeared_for_new_comment();

    }

    @When("click on blue colour")
    public void click_on_blue_colour() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.click_on_blue_colour();
    }

    @Then("T-shirt colour in the image should be changed to blue")
    public void t_shirt_colour_in_the_image_should_be_changed_to_blue() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.t_shirt_colour_in_the_image_should_be_changed_to_blue();
    }

    @When("Fetch the amount of product in variable")
    public void fetch_the_amount_of_product_in_variable() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.fetch_the_amount_of_product_in_variable();

    }

    @When("increase quantity to two and size to L")
    public void increase_quantity_to_two_and_size_to_l() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.increase_quantity_to_two_and_size_to_l();
    }

    @When("click on Add to cart")
    public void click_on_add_to_cart() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.click_on_add_to_cart();
    }

    @Then("User gets success message in popup")
    public void user_gets_success_message_in_popup() throws InterruptedException {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_gets_success_message_in_popup();
    }

    @Then("User gets correct quantity and color")
    public void user_gets_correct_quantity_and_color() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_gets_correct_quantity_and_color();
    }

    @Then("user gets correct price as per quantity")
    public void user_gets_correct_price_as_per_quantity() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_gets_correct_price_as_per_quantity();
    }

    @When("User click on proceed to checkout")
    public void user_click_on_proceed_to_checkout() {
        ProductDetails_Page_Objects ProductPageObject = new ProductDetails_Page_Objects(testContext);
        ProductPageObject.user_click_on_proceed_to_checkout();
    }

    @Then("User sees the product name and availability as Instock")
    public void user_sees_the_product_name_and_availability_as_instock() {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.user_sees_the_product_name_and_availability_as_instock();
    }

    @Then("User sees the unit price and quantity as set earlier")
    public void user_sees_the_unit_price_and_quantity_as_set_earlier() {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.user_sees_the_unit_price_and_quantity_as_set_earlier();
    }

    @Then("Check the Total is equal to twice the amount with $ {double} for shipping")
    public void check_the_total_is_equal_to_twice_the_amount_with_$_for_shipping(Double double1) throws InterruptedException {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.check_the_total_is_equal_to_twice_the_amount_with_$_for_shipping(double1);
    }

    @When("user Click on Proceed to Check out again and reach till payment and click on Terms and condition check box")
    public void user_click_on_proceed_to_check_out_again_and_reach_till_payment_and_click_on_terms_and_condition_check_box() {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.user_click_on_proceed_to_check_out_again_and_reach_till_payment_and_click_on_terms_and_condition_check_box();
    }

    @When("On Payment Page click on Pay by bank wire and Click on I confirm my Order")
    public void on_payment_page_click_on_pay_by_bank_wire_and_click_on_i_confirm_my_order() {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.on_payment_page_click_on_pay_by_bank_wire_and_click_on_i_confirm_my_order();
    }

    @Then("Check the order submit page and message {string} also check is amount is right")
    public void check_the_order_submit_page_and_message_also_check_is_amount_is_right(String string) {
        ShoppingCart_Page_Objects ShoppingCartPageObject = new ShoppingCart_Page_Objects(testContext);
        ShoppingCartPageObject.check_the_order_submit_page_and_message_also_check_is_amount_is_right(string);
    }

}