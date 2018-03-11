@todo @api
Feature: Recipes

Scenario: 201 - Store recipe
	When a new element is posted to the collection "/api/recipes":
		"""
		{
			"name":"Pancakes",
			"description":"Pancake base recipe",
			"yield":"4 people",
			"ingredients":[],
			"instructions":[]
		}
		"""
	Then the location of the new element is returned
	
Scenario: 404 - Cannot find recipe
	When the element at "/api/recipes/a98b4423-f2ea-486f-8454-9b8558c7c186" is retrieved
	Then the element is not found

Scenario: 200 - Retrieve recipe
	Given a new element is posted to the collection "/api/recipes":
		"""
		{
			"name":"Pancakes",
			"description":"Pancake base recipe",
			"yield":"4 people",
			"ingredients":[],
			"instructions":[]
		}
		"""
	When the element is requested
	Then the JSON returned is:
		"""
		{
			"name":"Pancakes",
			"description":"Pancake base recipe",
			"yield":"4 people",
			"ingredients":[],
			"instructions":[]
		}
		"""

Scenario: 200 - Retrieve collection
	Given a new element is posted to the collection "/api/recipes":
		"""
		{
			"name":"Pancakes",
			"description":"Pancake base recipe",
			"yield":"4 people",
			"ingredients":[],
			"instructions":[]
		}
		"""
	And a new element is posted to the collection "/api/recipes":
		"""
		{
			"name":"Boiled egss",
			"description":"Boiled eggs in a few minutes",
			"yield":"1 person",
			"ingredients":[],
			"instructions":[]
		}
		"""
	When the collection "/api/recipes" is retrieved
	Then the JSON collection contains:
		"""
		[
			{
				"name":"Pancakes",
				"description":"Pancake base recipe",
				"yield":"4 people",
				"ingredients":[],
				"instructions":[]
			},
			{
				"name":"Boiled egss",
				"description":"Boiled eggs in a few minutes",
				"yield":"1 person",
				"ingredients":[],
				"instructions":[]
			}
		]
		"""
	