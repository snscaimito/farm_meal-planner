@user_interface
Feature: Week Plan UI Behavior

Scenario: Clear search field after search
    When I search for recipes with ingredient Egg
    Then the search field is empty
    