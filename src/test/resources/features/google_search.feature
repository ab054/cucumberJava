Feature: Google Search

  Scenario Outline: Verify amount of results is sufficient
    Given a user navigates to Google's main page
    When type "<query>" and submit
    Then amount of results is greater than "<numberOfResults>"

    Examples:
      | query                   | numberOfResults |
      | Portnov Computer School | 10000           |
      | Portnov School          | 10000           |