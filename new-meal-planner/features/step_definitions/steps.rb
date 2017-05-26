When(/^I load the page$/) do
  visit MainPage
end

Then(/^the title is "([^"]*)"$/) do |arg1|
  on(MainPage) do |page|
    expect(page.title).to eql 'Meal Planner'
  end
end