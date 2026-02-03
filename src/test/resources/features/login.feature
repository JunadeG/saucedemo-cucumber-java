Feature: SauceDemo Login

#  Scenario Outline: Successful login
#    Given the user is on the SauceDemo login page
#    When the user enters username "<username>" and password "<password>"
#    And clicks the login button
#    Then the user should be redirected to the inventory page
#
#
#    #the headings on top
#      Examples:
#        |username       |password      |
#        |standard_user  |secret_sauce  |
#        |locked_out_user|secret_sauce  |


#  examples of how we can test multiple users instead of running the same thing over and over
#    Scenario Outline: Login with multiple users
#    Given the user is on the login page
#    When the user enters "<user>" and "<pass>"
#    Then login should be "<result>"
#
#    Examples:
#      | user          | pass         | result  |
#      | standard_user | secret_sauce | success |
#      | locked_user   | secret_sauce | fail    |

  Scenario: Successful login
    Given the user is on the SauceDemo login page
    When the user enters username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the inventory page

  Scenario: Locked out user login
    Given the user is on the SauceDemo login page
    When the user enters username "locked_out_user" and password "secret_sauce"
    And clicks the login button
    Then an error message containing "Epic sadface: Sorry, this user has been locked out." should be dispalyed

  Scenario: Add a product to the shopping cart
    Given the user is on the SauceDemo login page
    When the user enters username "standard_user" and password "secret_sauce"
    And clicks the login button
    And clicks the "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1" item
