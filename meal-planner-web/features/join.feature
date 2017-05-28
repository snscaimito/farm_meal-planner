Feature: Join Meal Planner

Scenario: Join with Google Account
	Given I am not yet a member
	When I use my existing Google account to join
	Then I am a member
	And I have access to my cookbook
	
Scenario: Join with email address
	Given I am not yet a member
	When I join using my email address
	Then I am a member
	And I have access to my cookbook
