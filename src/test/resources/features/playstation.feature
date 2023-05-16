Feature: Authentication Form

  Scenario: clicking multiple times on the button
    Given open "https://www.playstation.com/en-us/"
    And click to "xpath=//*[@id='menu-button-primary--msg-services']"
    When click to "css=.shared-nav__secondary-item:nth-child(1) > #link-secondary--msg-ps-plus"
    And click to "xpath=//span[@class='tertiary-cta__label']"
    And rightClick to "xpath=//span[@class='tertiary-cta__label']"
    Then click to "css=.tier-selector__content:nth-child(2) .psw-radio:nth-child(3)"
    And assert that "xpath=//input[@type='radio'][@value='12-Month Plan']" checked
    And click to "css=.tier-selector__content:nth-child(2) .psw-fill-x:nth-child(2) > .psw-fill-x"

  Scenario: converted scenario
    Given user navigates to the main PlayStation page
    And expands Services menu from top navigation bar
    When selects PS Plus option
    And submits Join PlayStation Plus button
    Then user selects 12-months plan
    And verify that 12-months option is indeed selected
    And add it to the cart