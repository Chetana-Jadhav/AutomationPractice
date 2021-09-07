Feature: Sign Up Feature

  @SignUp
  Scenario: User is able to sign up
    #Given User opened browser
    Given User navigated to "http://automationpractice.com/index.php"
    And User clicked on sign in link and entered email as "mom@test.com"
    And User clicked on Create an account button
    And user fill the form with below details
      | FirstName              | Jen                     |
      | LastName               | Aniston                 |
      | Password               | Jen22                   |
      | First_Name             | Jen                     |
      | Last_Name              | Aniston                 |
      | company                | NA                      |
      | Address                | New Street, Church road |
      | Address2               | colony no. 2            |
      | city                   | Mumbai                  |
      | Zipcode                | 01234                    |
      | Additional information | No                      |
      | Home Phone             | 1234561234              |
      | Mobile Phone           | 1122334455              |
      | Assigned Address       | India                   |
    And click on Register button
    Then User account should be created and success message should be given
