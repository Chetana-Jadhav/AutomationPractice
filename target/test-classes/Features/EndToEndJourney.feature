Feature: End to end user journey
  @EndToEndJourney
  Scenario: User is able to perform end to end journey
    Given user is logged in with email as "myaccount@test.com" and password as "Jen22"
    When user select product category as T shirts
    And Click on the product name
    And Fetch the amount of product in variable
    And increase quantity to two and size to L
    And click on Add to cart
    Then User gets success message in popup
    And User gets correct quantity and color
    And user gets correct price as per quantity
    When User click on proceed to checkout
    Then User sees the product name and availability as Instock
    And User sees the unit price and quantity as set earlier
    And Check the Total is equal to twice the amount with $ 2.00 for shipping
    When user Click on Proceed to Check out again and reach till payment and click on Terms and condition check box
    And On Payment Page click on Pay by bank wire and Click on I confirm my Order
    Then Check the order submit page and message "Your order on My Store is complete." also check is amount is right



