Feature: As a user i want to visit cucumber page

Scenario: Visit cucumber pages
  Given I go to "https://cucumber.io/" page
  Then I should be on "https://cucumber.io/" page
  When I go to "https://cucumber.io/training" page
  Then I should be on "https://cucumber.io/training" page

