class MainPage
  include PageObject
  
  page_url :my_page_url
  
  def my_page_url
    "file://#{Dir.pwd}/build/site/index.html"
  end
end
