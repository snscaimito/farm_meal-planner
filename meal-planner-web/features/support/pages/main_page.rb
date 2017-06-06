class MainPage
  include PageObject
  
  button(:try_meal_planner, :id => 'tryIt')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/"
  end
  
end
