Feature: Login flow feature

  Scenario: The login page can be accessed from navigation bar
    Given "https://www.demo-opencart.com/" is accessed
    When user clicks on login button from navigation bar
    Then "index.php?route=account/login" is present within the current url

  Scenario: The user signs up in his account with valid credentials
    Given "https://www.demo-opencart.com/" is accessed
    When user clicks on login button from navigation bar
    And insert valid credentials
    Then "index.php?route=account/account" is present within the current url

  Scenario: The user logout from the open cart website
    Given "https://www.demo-opencart.com/" is accessed
    And user is logged in open cart webpage
    When user clicks on logout button from navigation bar
    Then "index.php?route=account/logout" is present within the current url

  Scenario: The user signs up in his account with invalid credentials
    Given "https://www.demo-opencart.com/" is accessed
    When user clicks on login button from navigation bar
    And insert invalid credentials
    Then an error message is showed