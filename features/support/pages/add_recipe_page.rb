class AddRecipePage
  include PageObject
  
  text_field(:name, :id => 'recipeName')
  text_area(:description, :id => 'recipeDescription')
  text_field(:yield, :id => 'recipeYield')
  button(:add, :id => 'saveRecipe')
  
  page_url :my_page_url
  
  def my_page_url
    SINGLE_APP ? "#{BASE_URL}/add" : "#{BASE_URL}/recipes/add"
  end
end
