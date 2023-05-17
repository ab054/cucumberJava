Feature: easychamp

  Scenario: easychamp
    Given open "https://easychamp.com/"
    And click to "css=.ModalMenuContainer_burger__IS_VP"
    And click to "css=a:nth-child(1) > .ModalMenuContainer_menu-item-ref__qJOPc"
    And wait for "xpath=//*[@id='__next']/div/div[2]/div/div/div[1]/div[1]" is visible
    And wait for "css=.ModalMenuContainer_burger__IS_VP" is visible
    And click to "css=.ModalMenuContainer_burger__IS_VP"
    And click to "css=a:nth-child(2) > .ModalMenuContainer_menu-item-ref__qJOPc"
    And click to "css=.ModalMenuContainer_burger__IS_VP"
    And click to "css=a:nth-child(3) > .ModalMenuContainer_menu-item-ref__qJOPc"