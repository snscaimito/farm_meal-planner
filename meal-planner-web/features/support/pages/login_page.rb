class LoginPage
  include PageObject
  
  text_field(:email, :id => 'email')
  text_field(:password, :id => 'password')
  button(:login, :id => 'submit')
  
  span(:login_rejected_message, :id => 'loginRejected')
  
  page_url :my_page_url
  
  def my_page_url
    "#{BASE_URL}/login.html"
  end
  
  def login_with(email, password)
    self.email = email
    self.password = password
    self.login
  end
end
