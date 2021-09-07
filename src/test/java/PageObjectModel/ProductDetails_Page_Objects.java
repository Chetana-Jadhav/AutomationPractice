package PageObjectModel;

import StepDefinition.StepDefs1;
import com.google.inject.Inject;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Interact;
import utils.TestContext;

import java.util.Iterator;
import java.util.Set;

@Log4j2
public class ProductDetails_Page_Objects {
    Scenario scenario;
    TestContext testContext;
   public ProductDetails_Page_Objects(TestContext testContext){
      this.testContext = testContext;

    }

    @Before
    public void set_up(Scenario scenario) {
       this.scenario = scenario;
    }

    private By TShirt_category = By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]");
    private By productName = By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    private By SendToFriend = By.xpath("//a[@id='send_friend_button']");
    private By FriendName = By.xpath("//input[@id='friend_name']");
    private By FriendEmail = By.xpath("//input[@id='friend_email']");
    private By SendEmailButton = By.xpath("//button[@id='sendEmail']");
    private By EmailSentSuccessMsg = By.xpath("//p[contains(text(),'Your e-mail has been sent successfully')]");
    private By writeReview = By.xpath("//a[contains(text(),'Write a review')]");
    private By CommentTitle = By.xpath("//input[@id='comment_title']");
    private By Comment = By.xpath("//textarea[@id='content']");
    private By sendComment = By.xpath("//button[@id='submitNewMessage']");
    private By commentAddedSuccessMsg = By.xpath("//p[contains(text(),'Your comment has been added and will be available ')]");
    private By BlueColour = By.xpath("//a[@id='color_14']");
    private By imagecolour = By.xpath("//img[@id='bigpic']");
    private By ProductAmount = By.xpath("//span[@id='our_price_display']");
    private By IncreaseQntyButton = By.xpath("//i[@class='icon-plus']");
    private By sizeSelect = By.xpath("//select[@id='group_1']");
    private By AddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    private By AddToCartSUccessMsg = By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]/i[1]");
    private By TotalProductPrice = By.xpath("//span[@class='ajax_block_products_total']");
    private By TotalShipping = By.xpath("//span[@class='ajax_cart_shipping_cost']");
    private By Total = By.xpath("//span[@class='ajax_block_cart_total']");
    private By Quantity = By.xpath("//span[@id='layer_cart_product_quantity']");
    private By color = By.xpath("//span[@id='layer_cart_product_attributes']");
    private By ProceedToCheckout = By.xpath("//a[@class='btn btn-default button button-medium']");


    public void user_select_product_category_as_t_shirts() {
        testContext.getDriver().findElement(TShirt_category).click();
        log.debug("T-shirt category clicked");

    }

    public void click_on_the_product_name() {
        testContext.getDriver().findElement(productName).click();
        log.debug("Product name clicked");
    }

    public void click_on_send_to_a_friend_link_fill_the_details_and_click_on_send() {
        JavascriptExecutor jse = (JavascriptExecutor) testContext.getDriver();
        jse.executeScript("window.scrollBy(0,1000)", "");
        testContext.getDriver().findElement(SendToFriend).click();
        Set<String> handles = testContext.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String childWindowId = it.next();
        testContext.getDriver().switchTo().window(childWindowId);
        log.debug("switched on popup");
        testContext.getDriver().findElement(FriendName).sendKeys("Monica");
        log.debug("Friend Name entered as Monica");
        testContext.getDriver().findElement(FriendEmail).sendKeys("monica@test.com");
        log.debug("Friend email entered as monica@test.com");
        testContext.getDriver().findElement(SendEmailButton).click();
        log.debug("Send Email button clicked");
    }

    public void message_should_be_appeared_that_email_sent_in_a_pop_up() {
        boolean ExpectedSuccessMsg = testContext.getDriver().findElement(EmailSentSuccessMsg).isDisplayed();
        Assert.assertEquals(ExpectedSuccessMsg, true);
        log.debug("Email sent success message validated");

    }

    public void user_click_on_write_review_and_fill_the_form() {
        JavascriptExecutor jse = (JavascriptExecutor) testContext.getDriver();
        jse.executeScript("window.scrollBy(0,1000)", "");
        testContext.getDriver().findElement(writeReview).click();
        Set<String> handles = testContext.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String childWindowId = it.next();
        testContext.getDriver().switchTo().window(childWindowId);
        log.debug("switched on popup");
        testContext.getDriver().findElement(CommentTitle).sendKeys("Product Review");
        log.debug("Review title entered");
        testContext.getDriver().findElement(Comment).sendKeys("This is dummy product review");
        log.debug("Review comment entered");
    }

    public void user_click_on_send_button() {
        testContext.getDriver().findElement(sendComment).click();
        log.debug("Send Comment button clicked");
    }

    public void success_message_should_be_appeared_for_new_comment() {
        boolean commentPostedMsg = testContext.getDriver().findElement(commentAddedSuccessMsg).isDisplayed();
        Assert.assertEquals(commentPostedMsg, true);
        log.debug("Comment Added success message validated");
    }

    public void click_on_blue_colour() {
        String color = testContext.getDriver().findElement(imagecolour).getAttribute("src");
        System.out.println(color);
        testContext.getDriver().findElement(BlueColour).click();
        log.debug("clicked on blue colour");
    }

    public void t_shirt_colour_in_the_image_should_be_changed_to_blue() {
        String blue_colour = testContext.getDriver().findElement(imagecolour).getAttribute("src");
        Assert.assertNotEquals(blue_colour, "http://automationpractice.com/img/p/1/1-large_default.jpg");
        log.debug("Product image color change validated");
    }

    public void fetch_the_amount_of_product_in_variable() {
        WebElement ProductPrice = testContext.getDriver().findElement(ProductAmount);
        String product_price = ProductPrice.getText();
        log.debug("Product amount fetched as :" + product_price);
        //scenario.log("The Price Of the Product is : " +product_price);

    }

    public void increase_quantity_to_two_and_size_to_l() {
        testContext.getDriver().findElement(IncreaseQntyButton).click();
        log.debug("Quantity increased");
        Select size = new Select(testContext.getDriver().findElement(sizeSelect));
        size.selectByVisibleText("L");
        log.debug("Product size selected as L");
    }

    public void click_on_add_to_cart() {
        testContext.getDriver().findElement(AddToCart).click();
        log.debug("Add to cart button clicked");
    }

    public void user_gets_success_message_in_popup() throws InterruptedException {
        Thread.sleep(2000);
        Set<String> handles = testContext.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String childWindowId = it.next();
        testContext.getDriver().switchTo().window(childWindowId);
        Thread.sleep(2000);
        WebElement successmsg = testContext.getDriver().findElement(AddToCartSUccessMsg);
        String Success_Msg = successmsg.getText();
        //scenario.log("Success Message given as: " +Success_Msg);
        boolean Expectedresult = successmsg.isDisplayed();
        Assert.assertEquals(Expectedresult, true);
        log.debug("Product added to cart. Success message validated");

    }

    public void user_gets_correct_quantity_and_color() {
        String ActualShownQnty = testContext.getDriver().findElement(Quantity).getText();
        String ActualShownColor = testContext.getDriver().findElement(color).getText();
        Assert.assertEquals(ActualShownQnty, "2");
        log.debug("Product quantity validated");
        Assert.assertEquals(ActualShownColor, "Orange, L");
        log.debug("Product color and size validated");

    }

    public void user_gets_correct_price_as_per_quantity() {
        String TotalPrice = testContext.getDriver().findElement(TotalProductPrice).getText();
        String Total_Shipping = testContext.getDriver().findElement(TotalShipping).getText();
        String GrandTotal = testContext.getDriver().findElement(Total).getText();
        float price = 16.51f;
        int qnty = 2;
        float expectedTotalPrice = price * qnty;
        float expectedGrandTotal = expectedTotalPrice + 2;
        Assert.assertEquals(TotalPrice, "$" + expectedTotalPrice);
        log.debug("Price validated");
        Assert.assertEquals(Total_Shipping, "$2.00");
        log.debug("Shipping validated");
        Assert.assertEquals(GrandTotal, "$" + expectedGrandTotal);
        log.debug("Grand Total validated");
    }

    public void user_click_on_proceed_to_checkout() {
        testContext.getDriver().findElement(ProceedToCheckout).click();
        log.debug("Proceed to checkout button clicked");
    }
}

