Feature: Authentication Form

  Scenario: clicking multiple times on the button
    Given open "https://www.lifetwig.com/login"
    Then type "demondomin7@gmail.com" in "id=login_email"
    And type "Saske_2600" in "id=login_password"
    And click to "xpath=//button[@type='submit']"
    Then assert element "xpath=//a[contains(@href, '/user-profile')]" present


  Scenario Outline: clicking multiple times on the button
    Given open "https://www.lifetwig.com/login"
    Then type "<loginID>" in "id=login_email"
    And type "<password>" in "id=login_password"
    And click to "xpath=//button[@type='submit']"
    Then assert element "xpath=//a[contains(@href, '/user-profile')]" present

    Examples:
      | loginID               | password   |
      | demondomin7@gmail.com | Saske_2600 |

