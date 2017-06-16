Feature: Login

Scenario: Login failure
    When I log in as "sns@caimito.net" with password "irgendwas"
    Then my login attempt is rejected

Scenario: Successful login
    When I log in as "sns@caimito.net" with password "geheim"
    Then I can start planning meals for the week
