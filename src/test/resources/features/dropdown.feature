Feature: clicking N times

  Scenario: clicking multiple times on the button
    Given open "http://the-internet.herokuapp.com/dropdown"
    When select text "Option 1" in "id=dropdown" dropdown
    Then option "Option 1" is selected in "id=dropdown" dropdown


