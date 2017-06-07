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
  request = { :name => 'Egg-Asparagus', 
    :description => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 
    :yield => '3 people',
    :ingredients => [ '3 eggs' ] }
  RestClient.put 'http://localhost:8080/recipe', request.to_json, {:content_type => :json}
end

Then(/^I see the Egg\-Asparagus recipe in the search result list$/) do
  on WeekPlanningPage do |page|
    expect(page.searchResultList).to include('Egg-Asparagus')
  end
end

When(/^I search for recipes with ingredient Egg$/) do
  on WeekPlanningPage do |page|
    page.searchTerm = 'egg'
    page.search
  end
end


Given(/^I am not yet a member$/) do
  @user_id = nil
end

When(/^I join using my email address$/) do
  visit(MainPage) do |page|
    page.join_with_email
  end
end

Then(/^I am a member$/) do
  member_db = Psych.load_file(MEMBER_DB)
end
