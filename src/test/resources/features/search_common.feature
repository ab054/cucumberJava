Feature: UI Search

  User should be able to type any text as a query and receive reasonable amount of results


  Rule: Google search should return results

    @search
    Scenario: Search works
      Given open "https://www.google.com"
      When type "Portnov Computer School" in "name=q"
      And send key "ENTER" to "name=q"
      And wait for "id=result-stats" is visible
      Then assert text "results" presented in "id=result-stats"

    Scenario Outline: Search works
      Given open "https://www.google.com"
      When type "<query>" in "name=q"
      And send key "ENTER" to "name=q"
      Then wait for "id=result-stats" is visible
      And assert text "results" presented in "id=result-stats"

      Examples:
        | query                   |
        | Portnov Computer School |
        | Portnov School          |