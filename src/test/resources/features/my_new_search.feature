Feature: UI Search

  User should be able to type any text as a query and receive reasonable amount of results


  Rule: Google search should return results

    Scenario: Search works
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "tomsmith" in "id=username"
      And type "SuperSecretPassword!" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert text "Secure Area" presented in "css=h2"

    Scenario: Wrong credentials don't work
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "tomsmithadfasdf" in "id=username"
      And type "wrongPassword" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert element "xpath=//*[@id='flash']" present

    Scenario: Wrong credentials numbers and password don't work
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "12312312312" in "id=username"
      And type "123123123123123" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert element "xpath=//*[@id='flash']" present



