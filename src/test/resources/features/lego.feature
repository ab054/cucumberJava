Feature: Lego Search

  User should be able to search for specific items and find results, add those items to the cart


  Rule: Lego search should return results

    @search
    Scenario: Search works
      Given open "https://www.lego.com/en-us"
      And wait for "xpath=//button[@type='submit'][text()='Continue']" is visible
      When click to "xpath=//button[@type='submit'][text()='Continue']"
      And wait for "xpath=/html/body/div[6]/div/aside/div/div/div[3]/div[1]/button[2]" is visible
      When click to "xpath=/html/body/div[6]/div/aside/div/div/div[3]/div[1]/button[2]"
      When click to "css=.MainBarstyles__OpenButton-sc-1cg7sjw-12 > .Icon__StyledSVG-lm07h6-0"
      When type "star wars" in "id=desktop-search-search-input"
      When click to "xpath=//button[contains(@class,'SearchButton')]"
      When click to "xpath=//*[@id='__next']/div[2]/header/div[2]/div[2]/div/div[5]/div/div/div[3]/div[2]/form/button[1]"
      When click to "css=*[data-test='product-leaf-cta-add-to-cart']"
      When click to "css=.CloseButtonstyles__StyledButton-sc-187mq57-0 > .Icon__StyledSVG-lm07h6-0"
