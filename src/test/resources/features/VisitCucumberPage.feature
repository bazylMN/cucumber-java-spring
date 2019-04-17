Feature: As a user i want to visit cucumber page

  Scenario Outline: Visit cucumber pages
    Given I go to <home> page
      Then I should be on <home> page
      When I click jam on menu
      Then I should be on <jam> page
      When I go to <training> page
      Then I should be on <training> page
    Examples:
      |home                 |jam                     |training                     |
      |https://cucumber.io/ |https://cucumber.io/jam |https://cucumber.io/training |


  Scenario: Try to sign up for GitHub
    Given I go to https://github.com/ page
      When I fill form fields with data
        |login    |loginfirst     |
        |email    |email@first.pl |
        |password |first123       |
      Then I should see form with filled fields
