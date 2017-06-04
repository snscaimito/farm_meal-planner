class MainPage
  include PageObject
  
  text_field(:email, :id => 'email')
  button(:join, :id => 'join')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/"
  end
  
  def join_with_email
    email = @@default_member_data[:stephan][:email]
    join

    if CLICK_DUMMY
      members = { :member => email }
      save_member_database(members)
    end
  end
end
