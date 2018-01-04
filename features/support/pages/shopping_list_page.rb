class ShoppingListPage
  include PageObject

  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/shoppingList.html"
  end
end
