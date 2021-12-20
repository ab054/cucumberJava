Feature: Google Search

  @home_page @home_page_display
  Scenario Outline: Verify amount of results is sufficient
    Given user navigates to Google search page
    When type and submit query "<query>"
    Then amount of results is greater than "<numberOfResults>"

    Examples:
      | query                   | numberOfResults |
      | Portnov Computer School | 10000           |
      | Portnov School          | 10000           |