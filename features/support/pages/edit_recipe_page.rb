class EditRecipePage < AddRecipePage

  button(:save, :id => 'saveRecipe')

  def modify_recipe
    self.name = "mod #{self.name}"
    self.save
  end

end