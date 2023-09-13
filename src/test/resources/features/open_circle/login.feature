Feature: open circle login

  Scenario: unauthorized user use invalid credentials should see error
    Given user opens main page
    When fills out form with invalid credentials
    Then invalid password error is displayed