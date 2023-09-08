Feature: COSTCO Search

  Scenario Outline: user receive reasonable amount of search results
    Given open "https://www.costco.com/"
    When type "<query>" in "css=#search-field"
    And click to "xpath=//form[@id='formcatsearch']/div[2]/button/i"
    Then assert text "<results>" presented in "id=rsltCntMsg"

    Examples:
      | query          | results                                   |
      | MacBook Air M2 | We found 4 results for \"MacBook Air M2\" |
      | iPhone 14 pro  | We found 4 results for \"iPhone 14 pro\"  |