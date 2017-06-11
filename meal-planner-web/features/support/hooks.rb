After do |scenario|
  if (scenario.failed?)
    time = Time.now.strftime('%Y_%m_%d_%Y_%H_%M_%S_')
    name_of_scenario = time + scenario.name.gsub(/\s+/, "_").gsub("/","_")
    file_path = "#{SCREENSHOTS_DIR}/#{name_of_scenario}.png"
    @browser.save_screenshot file_path
  end
end

Before do
  clear_members
  clear_recipes
end
