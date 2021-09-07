package PageObjectModel;

import StepDefinition.StepDefs1;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.TestContext;

@Log4j2
public class ShoppingCart_Page_Objects {
    Scenario scenario;
    TestContext testContext;

    public ShoppingCart_Page_Objects(TestContext testContext){
        this.testContext = testContext;
    }


    @Before
    public void set_up(Scenario scenario) {
        this.scenario = scenario;
    }

    private By productName = By.linkText("Faded Short Sleeve T-shirts");
    private By availability = By.xpath("//span[contains(text(),'In stock')]");
    private By unitPrice = By.xpath("//span[contains(text(),'$16.51')]");
    private By qnty = By.xpath("//input[@value='2']");
    private By Total = By.xpath("//span[@id='total_product_price_1_5_562416']");
    private By shipping = By.xpath("//td[@id='total_shipping']");
    private By ProceedToCheckout = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]");
    private By proceed_to_checkout = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]");
    private By termsOfSerivice = By.xpath("//input[@id='cgv']");
    private By Proceed_To_Checkout = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]");
    private By PayByBank = By.xpath("//a[@class='bankwire']");
    private By OrderConfirmButton = By.xpath("//span[contains(text(),'I confirm my order')]");
    private By OrderCompleteMsg = By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]");
    private By Amount = By.xpath("//strong[contains(text(),'$35.02')]");

    public void user_sees_the_product_name_and_availability_as_instock() {
        WebElement displayedProductName = testContext.getDriver().findElement(productName);
        Assert.assertEquals(displayedProductName.isDisplayed(), true);
        log.debug("Product Name validated");
       // scenario.log("Product Name Given in shopping cart is :" +displayedProductName);

        WebElement StockAvailability = testContext.getDriver().findElement(availability);
        Assert.assertEquals(StockAvailability.isDisplayed(), true);
        log.debug("Product availability validated");

    }

    public void user_sees_the_unit_price_and_quantity_as_set_earlier() {
        String Unit_Price = testContext.getDriver().findElement(unitPrice).getText();
        String Qnty = testContext.getDriver().findElement(qnty).getText();
        Assert.assertEquals(Unit_Price, "$16.51");
        log.debug("Unit price validated");
        // Assert.assertEquals(Qnty,"2");

    }

    public void check_the_total_is_equal_to_twice_the_amount_with_$_for_shipping(Double double1) throws InterruptedException {
        float unitprice = 16.51f;
        int qnt = 2;
        float TotalPrice = unitprice * qnt;
        Assert.assertEquals("$33.02", "$" + TotalPrice);
        log.debug("Product Price validated");
        Thread.sleep(2000);
        String ActualShipping = testContext.getDriver().findElement(shipping).getText();
        Assert.assertEquals(ActualShipping, "$" + double1 + "0");
        log.debug("Product shipping price validated");
    }

    public void user_click_on_proceed_to_check_out_again_and_reach_till_payment_and_click_on_terms_and_condition_check_box() {
        testContext.getDriver().findElement(ProceedToCheckout).click();
        log.debug("Proceed to checkout button clicked");
        testContext.getDriver().findElement(proceed_to_checkout).click();
        log.debug("Proceed to checkout button clicked");
        testContext.getDriver().findElement(termsOfSerivice).click();
        log.debug("Terms and conditions checked");
        testContext.getDriver().findElement(Proceed_To_Checkout).click();
        log.debug("Proceed to checkout button clicked");
    }

    public void on_payment_page_click_on_pay_by_bank_wire_and_click_on_i_confirm_my_order() {
        testContext.getDriver().findElement(PayByBank).click();
        log.debug("Pay By Bank wire selected");
        testContext.getDriver().findElement(OrderConfirmButton).click();
        log.debug("Order confirm button clicked");
    }

    public void check_the_order_submit_page_and_message_also_check_is_amount_is_right(String string) {
        Assert.assertEquals(testContext.getDriver().getTitle(), "Order confirmation - My Store");
        log.debug("Page title validated");
        String ordercompletedMsg = testContext.getDriver().findElement(OrderCompleteMsg).getText();
        Assert.assertEquals(ordercompletedMsg, string);
        log.debug("order completion success message validated");
        Assert.assertEquals(testContext.getDriver().findElement(OrderCompleteMsg).isDisplayed(), true);
        Assert.assertEquals(testContext.getDriver().findElement(Amount).getText(), "$35.02");
        log.debug("Total amount validated");
    }

}