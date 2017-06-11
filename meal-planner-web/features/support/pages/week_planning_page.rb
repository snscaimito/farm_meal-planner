class WeekPlanningPage
  include PageObject

  text_field(:searchTerm, :id => 'searchTerm')
  button(:search, :id => 'searchForRecipe')
  unordered_list(:searchResultList, :id => 'searchResultList')
  
  button(:signup, :id => 'signup')
  
  button(:new_recipe, :id => 'newRecipe')
  text_field(:name, :id => 'recipeName')
  text_field(:description, :id => 'recipeDescription')
  text_field(:yield, :id => 'recipeYield')
  
  unordered_list(:pick_list, :id => 'pickList')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/week/index.html"
  end
  
  def create_recipe_for_pancakes
    self.name = 'Pancakes'
    self.description = 'Delicious pancakes for the whole family'
    self.yield = '4 persons'
#    self.ingredients = [ [ '3', 'pcs', 'Eggs'], [ '400', 'gram', 'wheat flour'], ['1', 'spoon', 'salt'], ['750', 'ml', 'milk'] ]

    self.save
  end
  
end