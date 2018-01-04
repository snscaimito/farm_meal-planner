@todo
Feature: Join Meal Planner

Background:
    Given there are no registered members

Scenario: Try Meal Planner
    When I decide to try Meal Planner
    Then I can start planning meals for the week

Scenario: Encourage to join
    When I am planning my week
    Then I am encouraged to join
    
Scenario: Stop encouraging to join
    Given I am planning my week
    When I join as "sns@caimito.net"
    And I am planning my week
    Then I am not encouraged to join
