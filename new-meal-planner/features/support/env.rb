require 'page-object'
require 'page-object/page_factory'
require 'rspec-expectations'
require 'fileutils'

FileUtils.mkdir_p "build/features"
browser = Selenium::WebDriver.for :chrome

Before do
  @browser = browser
end

After do |scenario|
  if (scenario.failed?)
    time = Time.now.strftime('%Y_%m_%d_%Y_%H_%M_%S_')
    name_of_scenario = time + scenario.name.gsub(/\s+/, "_").gsub("/","_")
    file_path = "#{Dir.pwd}/build/features/#{name_of_scenario}.png"
    @browser.save_screenshot file_path
  end
end

at_exit do
  browser.close
end

World(PageObject::PageFactory)
