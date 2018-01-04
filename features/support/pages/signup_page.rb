class SignupPage
  include PageObject

  text_field(:email, :id => 'email')
  text_field(:password1, :id => 'password1')
  text_field(:password2, :id => 'password2')
  button(:signup, :id => 'submit')
  
  def register_with(username, password)
    self.email = username
    self.password1 = password
    self.password2 = password
    self.signup
  end
end
