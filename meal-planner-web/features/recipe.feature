Feature: Recipes

Scenario: Visitor sees public recipes
	Given I am not yet a member
	When I visit the site
	Then I see a small number of public recipes
	
Scenario: 
	Given I am a member
	When I access my cookbook
	Then I see a tag cloud of my recipes
	
