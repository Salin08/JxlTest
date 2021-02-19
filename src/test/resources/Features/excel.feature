Feature: Check google search functionality

  Scenario: Validate excel is working
    Given browser is open
    And user is on daraz website
    When user enters search products
    And hits Enter
    Then user read excel sheet and write over it
    