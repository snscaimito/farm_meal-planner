Feature: Non member plans meals for a week

Background:
    Given I am planning my week

Scenario: Search recipes
    Given the Egg-Asparagus recipe exists
    When I search for recipes with ingredient Egg
    Then I see the Egg-Asparagus recipe in the search result list

Scenario: Featured recipes
    Given the Egg-Asparagus recipe exists
    When I am planning my week
    Then I see teh Egg-Asparagus recipe as featured recipe
