Feature: Yahoo search

  Scenario: Search works
    Given open "https://www.yahoo.com/"
    When type "Portnov Computer School" in "id=ybar-sbq"
    And send key "ENTER" to "id=ybar-sbq"
    And wait for "css=.fc-smoke .fz-14" is visible for 10 millis
    Then assert text "results" presented in "css=.fc-smoke .fz-14"