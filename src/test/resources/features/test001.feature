Feature: Login

  User should be able to login and proceed to the application


  Rule: only authenticated user should proceed with the app

    Scenario: correct credentials are accepted
      Given open "https://www.roche-bobois.com/en/login"
      And type "dec.student2@gmail.com" in "id=login-form-email"
      And type "Monic@1337" in "id=login-form-password"
      And click to "css=.btn-primary"
      When click to "css=.col-lg-5 .account-sub-heading"
      Then assert text "PERSONAL INFORMATION" presented in "css=.col-lg-5 .account-sub-heading"