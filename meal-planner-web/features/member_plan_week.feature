Feature: Plan week as member

Background:
#    Given a member with email "sns@caimito.net" and password "geheim" exists
    Given I log in as "sns@caimito.net" with password "geheim"

Scenario: Pick list
    Given the Egg-Asparagus recipe exists
    When I am planning my week
    Then I see the Egg-Asparagus recipe in the pick list
    
#Scenario: Create new recipe
#    When I create the recipe for pancakes
#    Then the recipe for pancakes is available in the pick list
