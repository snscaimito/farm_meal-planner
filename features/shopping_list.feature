@todo
Feature: Shopping list based on weekly meal plan

Scenario: Shopping list
    Given I have planned to eat Egg-Asparagus for breakfast on Monday
    When I access my shopping list
    Then the ingredients for Egg-Asparagus are listed
