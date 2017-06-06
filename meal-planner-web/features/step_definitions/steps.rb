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
