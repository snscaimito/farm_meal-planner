@recipes
Feature: Recipe Management

  Scenario: Add recipe
    When I add a recipe
    Then the recipe is part of the recipe list

  @api
  Scenario: Find recipe as JSON
    When I add a recipe
    Then the recipe is part of the recipe list
    And the recipe is returned in JSON format

  Scenario: Edit Recipe
    Given then pancakes recipe exists
    When I modify the pancakes recipe
    Then the pancakes recipe has been modified

  Scenario: Delete Recipe
    Given then pancakes recipe exists
    When I delete the pancakes recipe
    Then the pancakes recipe does not exist
