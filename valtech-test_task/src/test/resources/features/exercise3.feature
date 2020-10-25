Feature: Exercise 3

  Scenario: Verify and print a list of all offices in the UK
    Given I am on home page
    When I click on menu
    And I click on offices
    And I click on United Kingdom
    Then Verify count of offices in the UK
    Then Print a list of all offices in the UK