@recipes
Feature: Recipe Management

  Scenario: Add recipe
    When I add a recipe
    Then the recipe is part of the recipe list

  Scenario: Edit Recipe
    Given the pancakes recipe exists
    When I modify the pancakes recipe
    Then the pancakes recipe has been modified

  Scenario: Delete Recipe
    Given the pancakes recipe exists
    When I delete the pancakes recipe
    Then the pancakes recipe does not exist
