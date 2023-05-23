Feature: UI Search

  User should be able to type any text as a query and receive reasonable amount of results


  Rule: Google search should return results

    @search
    Scenario: Search works
      Given open "https://www.google.com"
      When type "School" in "name=q" for 5 times
      And send key "ENTER" to "name=q"
      And wait for "id=result-stats" is visible for 1 millis
      Then assert text "results" presented in "id=result-stats"
      Then sleep for 10 seconds

    Scenario Outline: Search works
      Given open "https://www.google.com"
      When type "<query>" in "name=q"
      And send key "ENTER" to "name=q"
      Then wait for "id=result-stats" is visible
      And assert text "<text>" presented in "id=result-stats"

      Examples:
        | query                   | text    |
        | Portnov Computer School | results |
        | Portnov School          | result2 |