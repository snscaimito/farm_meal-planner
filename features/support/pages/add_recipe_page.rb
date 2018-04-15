class AddRecipePage
  include PageObject
  
  text_field(:name, :id => 'recipeName')
  text_area(:description, :id => 'recipeDescription')
  text_field(:yield, :id => 'recipeYield')
  button(:add, :id => 'saveRecipe')
  button(:add_row, :name => 'addRow')
  
  indexed_property(:ingredients, [
      [:text_field, :quantity, {:id => 'ingredients%s.quantity'}],
      [:text_field, :unit, {:id => 'ingredients%s.unit'}],
      [:text_field, :ingredient, {:id => 'ingredients%s.name'}]
    ])
    
  text_area(:instructions, :id => 'instructions')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/recipes/ui/add"
  end
end
