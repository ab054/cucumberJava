Feature: open circle login

  Scenario Outline: unauthorized user use invalid credentials should see error
    Given user credentials are "<login>" and "<password>"
    And user opens main page
    When fills out form with provided credentials
    Then error with "<errorText>" text is displayed

    Examples:
      | login        | password   | errorText                  |
      | ab@gmail.com | 1234567Qw! | Invalid email or password. |
      | ab@gmail.com | 1234       | too_short_error_message    |