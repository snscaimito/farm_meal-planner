require 'rspec'
require 'selenium-webdriver'

RSpec.describe 'Add Recipe' do
  before do
    @driver = Selenium::WebDriver.for :chrome
    @driver.get "http://localhost:4000/recipe/add.html"
  end

  after do |example|
    if example.exception
      @driver.save_screenshot "#{example.description}.png"
    end
    @driver.quit
  end

  it 'should name the recipe' do
    @driver.find_element(:css, "p[itemprop=name]").click
    @driver.find_element(:css, "textarea[itemprop=name]").send_key("Banana Cake")

    # click elsewhere
    @driver.find_element(:css, "p[itemprop=description]").click
    
    expect(@driver.find_element(:css, "[itemprop=name]").text).to eq("Banana Cake")
  end

  it 'should describe the recipe' do
    @driver.find_element(:css, "p[itemprop=description]").click
    @driver.find_element(:css, "textarea[itemprop=description]").send_key("Making banana cake is great")

    # click elsewhere
    @driver.find_element(:css, "p[itemprop=name]").click
    
    expect(@driver.find_element(:css, "[itemprop=description]").text).to eq("Making banana cake is great")
  end

  it 'should tell the yield' do
    @driver.find_element(:css, "span[itemprop=recipeYield]").click
    @driver.find_element(:css, "input[itemprop=recipeYield]").send_key("4 adults")

    # click elsewhere
    @driver.find_element(:css, "p[itemprop=name]").click
    
    expect(@driver.find_element(:css, "[itemprop=recipeYield]").text).to eq("4 adults")
  end

  it "should add one ingredient" do
    @driver.find_element(:css, "input[name=ingredientQuantity]").send_key("1")
    @driver.find_element(:css, "input[name=ingredientUnit]").send_key("spoonful")
    @driver.find_element(:css, "input[name=ingredientName]").send_key("Salt")
    @driver.find_element(:id, "addIngredient").click()
    
    expect(@driver.find_element(:css, "[itemprop=recipeIngredient]").text).to eq("1 spoonful Salt")
  end
  
  it "should add one instruction" do
    @driver.find_element(:id, "instruction").send_key("Heat pan")
    @driver.find_element(:id, "addInstruction").click()
    
    expect(@driver.find_element(:css, "[itemprop=recipeInstructions]").text).to eq("Heat pan")
  end
  
end