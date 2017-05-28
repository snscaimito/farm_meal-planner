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
