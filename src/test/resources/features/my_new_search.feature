Feature: Authentication Form

  User should be able to login with right credentials, wrongs credentials should not be accepted


  Rule: successfully authorized user should see welcome message

    Scenario: correct credentials are accepted
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "tomsmith" in "id=username"
      And type "SuperSecretPassword!" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert text "Secure Area" presented in "css=h2"

    Scenario: wrong credentials are not accepted
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "tomsmithadfasdf" in "id=username"
      And type "wrongPassword" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert element "xpath=//*[@id='flash']" present

    Scenario: wrong credentials (number) are not accepted
      Given open "https://the-internet.herokuapp.com/"
      And click to "linkText=Form Authentication"
      And type "12312312312" in "id=username"
      And type "123123123123123" in "id=password"
      When click to "xpath=//form[@id='login']/button/i"
      Then assert element "xpath=//*[@id='flash']" present



