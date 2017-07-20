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
    When I assign the Egg-Asparagus recipe to breakfast on Monday
    Then my meal plan lists Egg-Asparagus for breakfast on Monday

@user_interface
Scenario Outline: Assign recipe to meal slot
    Given the Egg-Asparagus recipe exists
    And I am planning my week
    When I assign the Egg-Asparagus recipe to <meal_event> on <day>
    Then my meal plan lists Egg-Asparagus for <meal_event> on <day>

    Examples:
    | meal_event | day       |
    | breakfast | monday    |
    | breakfast | tuesday   |
    | breakfast | wednesday |
    | breakfast | thursday  |
    | breakfast | friday    |
    | breakfast | saturday  |
    | breakfast | sunday    |
    
