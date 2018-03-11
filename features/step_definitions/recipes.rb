When("I add a recipe") do
  visit(AddRecipePage) do |page|
    page.name = PANCAKE_RECIPE[:name]
    page.description = PANCAKE_RECIPE[:description]
    page.yield = PANCAKE_RECIPE[:yield]
    
    PANCAKE_RECIPE[:ingredients].each_index do |index|
      page.add_row
      page.ingredients[index].quantity = PANCAKE_RECIPE[:ingredients][index][:quantity]
      page.ingredients[index].unit = PANCAKE_RECIPE[:ingredients][index][:unit]
      page.ingredients[index].ingredient = PANCAKE_RECIPE[:ingredients][index][:name]
    end
    
    page.instructions = PANCAKE_RECIPE[:instructions]
    
    page.add
  end
end

Then("the recipe is part of the recipe list") do
  visit(ListRecipesPage) do |page|
    expect(page.recipes_list).to include "Pancakes"
  end
end
