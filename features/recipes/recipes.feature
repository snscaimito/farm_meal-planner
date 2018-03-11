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
