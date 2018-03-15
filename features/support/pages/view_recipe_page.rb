class ViewRecipePage
  include PageObject

  link(:edit_recipe, :id => 'editRecipe')
  link(:delete_recipe, :id => 'deleteRecipe')

end