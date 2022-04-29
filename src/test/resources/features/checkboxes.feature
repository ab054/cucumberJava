Feature: user selects checkbox UI element

  Scenario: checkboxes are checked
    Given open "https://the-internet.herokuapp.com/"
    And click to "linkText=Checkboxes"
    When click to "xpath=(//input[@type='checkbox'])[1]"
    And click to "xpath=(//input[@type='checkbox'])[2]"
    Then assert that "css=input:nth-child(1)" checked
    And assert that "css=input:nth-child(3)" not checked