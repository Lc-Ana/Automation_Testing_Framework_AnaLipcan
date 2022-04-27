Feature: Registration flow feature

  @HomePage
  Scenario: The registration page can be accessed from navigation bar
    Given "https://www.demo-opencart.com/" is accessed
    When user clicks on register button from navigation bar
    Then "index.php?route=account/register" is present within the current url

    Scenario: Open cart page is accessible
      When "https://www.demo-opencart.com/" is accessed
      Then "https://www.demo-opencart.com/" is present within the current url

