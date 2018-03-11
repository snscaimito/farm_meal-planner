When("I add a recipe") do
  visit(AddRecipePage) do |page|
    fill_form(page, PANCAKE_RECIPE)
    page.add
  end
end

Then("the recipe is part of the recipe list") do
  visit(ListRecipesPage) do |page|
    expect(page.recipes_list).to include "Pancakes"
  end
end
