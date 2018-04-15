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
    @recipe_link = @browser.link text: 'Pancakes'
    expect(@recipe_link).to exist
  end
end

When(/^I modify the pancakes recipe$/) do
  visit(ListRecipesPage).view_recipe(PANCAKE_RECIPE[:name])
  on(ViewRecipePage).edit_recipe
  on(EditRecipePage).modify_recipe
end

Given(/^the pancakes recipe exists$/) do
  response = RestClient.put "#{BASE_URL}/recipes/api/recipes/", PANCAKE_RECIPE.to_json, {:content_type => :json}
  @last_recipe_url = response.headers[:location]
end


Then(/^the pancakes recipe has been modified$/) do
  rest_response = RestClient.get @last_recipe_url, {accept: :json}
  json_object = JSON.parse rest_response
  expect(json_object["name"]).to eq("mod #{PANCAKE_RECIPE[:name]}")
end


When(/^I delete the pancakes recipe$/) do
  visit(ListRecipesPage).view_recipe(PANCAKE_RECIPE[:name])
  on(ViewRecipePage).delete_recipe
end


Then(/^the pancakes recipe does not exist$/) do
  expect { RestClient.get @last_recipe_url, {accept: :json} }.to raise_error(RestClient::NotFound)
end
