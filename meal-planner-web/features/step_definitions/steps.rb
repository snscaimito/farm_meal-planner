When(/^I visit the Meal Planner$/) do
  visit MainPage
end

Then(/^I see the main page$/) do
  expect(on(MainPage).title).to eql("Welcome to Meal Planner")
end

When(/^I decide to try Meal Planner$/) do
  visit(MainPage).try_meal_planner
end

Then(/^I can start planning meals for the week$/) do
  on WeekPlanningPage do |page|
    page.wait_until { page.text.include? 'Meal Plan for Week' }
  end
end

Given(/^the Egg\-Asparagus recipe exists$/) do
  create_egg_asparagus_recipe
end

Then(/^I see the Egg\-Asparagus recipe in the search result list$/) do
  on WeekPlanningPage do |page|
    expect(page.searchResultList).to include('Egg-Asparagus')
  end
end

When(/^I search for recipes with ingredient Egg$/) do
  visit WeekPlanningPage do |page|
    page.searchTerm = 'Egg'
    page.search
  end
end

Then(/^the search field is empty$/) do
  expect(on(WeekPlanningPage).searchTerm).to be_empty
end

When(/^I am planning my week$/) do
  visit WeekPlanningPage
end

Then(/^I am encouraged to join$/) do
  expect(on(WeekPlanningPage).signup_element).to be_visible
end

When(/^I join as "([^"]*)"$/) do |person|
  on(WeekPlanningPage).signup
  on(SignupPage).register_with(person, 'geheim')
end

Then(/^I am not encouraged to join$/) do
  expect(on(WeekPlanningPage).signup_element).not_to be_visible
end

Given(/^there are no registered members$/) do
  clear_members
end

Given(/^a member with email "([^"]*)" and password "([^"]*)" exists$/) do |email, password|
  register_member_with email, password
end

When(/^I create the recipe for pancakes$/) do
  visit(WeekPlanningPage) do |page|
    page.new_recipe
    page.create_recipe_for_pancakes
  end
end

Then(/^the recipe for pancakes is available in the pick list$/) do
  on(WeekPlanningPage) do |page|
  end
end

Given(/^I log in as "([^"]*)" with password "([^"]*)"$/) do |email, password|
  visit(LoginPage).login_with email, password
end

Then(/^my login attempt is rejected$/) do
  expect(on(LoginPage).login_rejected_message_element).to be_visible
end

Then(/^I see the Egg\-Asparagus recipe as featured recipe$/) do
  expect(on(WeekPlanningPage).pick_list_name).to eql 'Featured Recipes'
  expect(on(WeekPlanningPage).pick_list).to include('Egg-Asparagus')
end

Then(/^I see the Egg\-Asparagus recipe in the pick list$/) do
  expect(on(WeekPlanningPage).pick_list_name).to eql 'My personal pick list'
  expect(on(WeekPlanningPage).pick_list).to include('Egg-Asparagus')
end

When(/^I assign the Egg\-Asparagus recipe to ([^"]*) on ([^"]*)$/) do |meal_event, day|
  on(WeekPlanningPage) do |page|
    first_recipe = page.pick_list_element.lis.first.div
    menu = first_recipe.div(:class => 'recipe-menu')
    menu.click
    
    @browser.ul(:id => day.downcase).children[0].span(:id => meal_event.downcase).click
    add_recipe_to_plan = @browser.button(:id => "addRecipeToPlan")
    add_recipe_to_plan.click
  end
end

Then(/^my meal plan lists Egg\-Asparagus for ([^"]*) on ([^"]*)$/) do |meal_event, day|
  on(WeekPlanningPage) do |page|
    meals = @browser.element(:xpath => "//div[@id='#{day.downcase}']/div[@class='mealEvent']/ul[@id='#{meal_event.downcase}']")
    expect(meals.text).to include "Egg-Asparagus"
  end
end

Given(/^I have planned to eat Egg\-Asparagus for breakfast on Monday$/) do
  step "the Egg-Asparagus recipe exists"
  step "I am planning my week"
  step "I assign the Egg-Asparagus recipe to breakfast on Monday"
end

When(/^I access my shopping list$/) do
  visit(ShoppingListPage)
end

Then(/^the ingredients for Egg\-Asparagus are listed$/) do
  expect(on(ShoppingListPage).text).to include "3 pcs Eggs", "200 gram Asparagus"
end
