class ListRecipesPage
  include PageObject

  div(:recipes_list, :id => 'recipesList')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/recipes"
  end
end
