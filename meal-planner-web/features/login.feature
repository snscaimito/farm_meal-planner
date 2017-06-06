Feature: Login

    Scenario: Login failure
        Given I am not yet a member
        When I login
        Then my login attempt is rejected
