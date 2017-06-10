class WeekPlanningPage
  include PageObject

  text_field(:searchTerm, :id => 'searchTerm')
  button(:search, :id => 'searchForRecipe')
  unordered_list(:searchResultList, :id => 'searchResultList')
  
  button(:signup, :id => 'signup')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/week/index.html"
  end
  
end