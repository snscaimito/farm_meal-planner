When(/^I visit the Meal Planner$/) do
  visit MainPage
end

Then(/^I see the main page$/) do
  expect(on(MainPage).title).to eql("Welcome to Meal Planner")
end

When(/^I decide to try Meal Planner$/) do
  visit MainPage do |page|
    page.try_meal_planner
  end
end

Then(/^I can start planning meals for the week$/) do
  expect(on(WeekPlanningPage).title).to eql('Meal Plan for Week')
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
