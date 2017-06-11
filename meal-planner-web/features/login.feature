Feature: Login

Scenario: Login failure
    When I log in as "sns@caimito.net" with password "geheim"
    Then my login attempt is rejected

Scenario: Successful login
    Given a member with email "sns@caimito.net" and password "geheim" exists
    When I log in as "sns@caimito.net" with password "geheim"
    Then I can start planning meals for the week
