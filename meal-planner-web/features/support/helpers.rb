def clear_members
  # for now do nothing until Spring Security has been used properly
#  RestClient.delete "#{BASE_URL}/members"
end

def clear_recipes
  begin
    RestClient.delete "#{BASE_URL}/recipes"
  rescue RestClient::ExceptionWithResponse => e
    e.response
  end
end

def create_egg_asparagus_recipe
  request = { :name => 'Egg-Asparagus', 
    :description => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 
    :yield => '3 people',
    :ingredients => [ '3 eggs' ] }
  RestClient.put "#{BASE_URL}/recipes", request.to_json, {:content_type => :json}
end

def register_member_with(email, password)
  request = { :email => email, :password => password }
  RestClient.put "#{BASE_URL}/members", request.to_json, {:content_type => :json}
end
