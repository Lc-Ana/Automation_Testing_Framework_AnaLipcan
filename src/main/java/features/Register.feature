Feature: Registration flow feature

  Background:
    Given "https://www.demo-opencart.com/" is accessed

  Scenario: Open cart page is accessible
    Then "https://www.demo-opencart.com/" is present within the current url

  Scenario: The registration page can be accessed from navigation bar
    When user clicks on register button from navigation bar
    Then "index.php?route=account/register" is present within the current url

  Scenario Outline: Error message is displayed when providing invalid data for <affectedField>
    And user clicks on register button from navigation bar
    When the register fields are populated with the following data:
      | firstName       | <firstName> |
      | lastName        | <lastName>  |
      | email           | <email>     |
      | phoneNumber     | <phone>     |
      | password        | pass123     |
      | confirmPassword | pass123     |
    And privacyPolicyCheckBox is clicked
    And continue button is clicked
    Then The following key words are present within an error message
      | <errorMessage> |
    Examples:
      | affectedField | firstName                         | lastName | email          | phone      | errorMessage                                    |
      | Email         | Ana                               | Lipcan   |                | 0666666666 | appear to be valid!                             |
      | First Name    |                                   | Lipcan   | lana@gmail.com | 0666666666 | First Name must be between 1 and 32 characters! |
      | First Name    | sdfghjklkjhgfdsasdfghjklkjhgfdswe | Lipcan   | lana@gmail.com | 0666666666 | First Name must be between 1 and 32 characters! |
      | Last Name     | Ana                               |          | lana@gmail.com | 0666666666 | Last Name must be between 1 and 32 characters!  |
      | Phone         | Ana                               | Lipcan   | lana@gmail.com |            | Telephone must be between 3 and 32 characters!  |
      | Phone         | Ana                               | Lipcan   | lana@gmail.com | 01         | Telephone must be between 3 and 32 characters!  |
