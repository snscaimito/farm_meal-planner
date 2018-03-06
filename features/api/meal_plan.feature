@api
Feature: Work with Meal Plans

Scenario: Retrieve Meal Plan
	Given the Pancakes recipe exists
	When the endpoint "/api/mealPlan" is called with:
	"""
		{
		  "beginningCycleNumber": 8,
		  "lengthInCycles": 7,
  		  "name": "First week of January",
		  "mealCycles": [
		    {
		      "cycleNumber": 8,
		      "mealSlots": [
		        {
		          "slotName": "breakfast",
		          "recipes": [
		          	"id"
		          ]
		        }
		      ]
		    }
		  ]
		}
	"""
	Then the JSON should be:
		"""
		{
		  "beginningCycleNumber": 8,
		  "lengthInCycles": 7,
  		  "name": "First week of January",
		  "mealCycles": [
		    {
		      "cycleNumber": 8,
		      "mealSlots": [
		        {
		          "slotName": "breakfast",
		          "recipes": [
		            {
		              "name": "Pancakes",
		              "yield": "4",
		              "description": "Pancake base recipe",
		              "id": "string",
		              "ingredients": [
		                {
		                  "name": "Eggs",
		                  "quantity": 3,
		                  "unit": "pcs"
		                },
		                {
		                  "name": "Flour",
		                  "quantity": 400,
		                  "unit": "gram"
		                },
		                {
		                  "name": "Milk",
		                  "quantity": 700,
		                  "unit": "ml"
		                }
		              ],
		              "instructions": [
		                "Mix all together"
		              ]
		            }
		          ]
		        }
		      ]
		    }
		  ]
		}
		"""