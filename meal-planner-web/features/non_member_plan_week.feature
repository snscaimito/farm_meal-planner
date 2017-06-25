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
    Then I see the Egg-Asparagus recipe as featured recipe

Scenario: Assign recipe to meal slot
    Given the Egg-Asparagus recipe exists
    And I am planning my week
    When I assign the Egg-Asparagus recipe to the breakfast meal slot on Monday
    Then my meal plan lists Egg-Asparagus for Monday
