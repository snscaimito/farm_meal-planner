Feature: Recipe Management

Scenario: Add recipe
  When I add a recipe
  Then the recipe is part of the recipe list
  