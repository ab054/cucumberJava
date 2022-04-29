Feature: clicking N times

  Scenario: clicking multiple times on the button
    Given open "https://the-internet.herokuapp.com/"
    And click to "linkText=Checkboxes"
    And click to "xpath=(//input[@type='checkbox'])[1]" 11 times
    And checkbox "xpath=(//input[@type='checkbox'])[1]" should be selected "false"