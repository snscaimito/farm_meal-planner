def clear_members
  # for now do nothing until Spring Security has been used properly
#  RestClient.delete "#{BASE_URL}/members"
end

def clear_recipes
  begin
    RestClient.delete "#{BASE_URL}/api/recipes"
  rescue RestClient::ExceptionWithResponse => e
    e.response
  end
end

def create_egg_asparagus_recipe
  request = { :name => 'Egg-Asparagus', 
    :description => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 
    :yield => '3 people',
    :ingredients => [ '3 eggs', '200 gram asparagus' ] }
  RestClient.put "#{BASE_URL}/api/recipes", request.to_json, {:content_type => :json}
end

def register_member_with(email, password)
  request = { :email => email, :password => password }
  RestClient.put "#{BASE_URL}/api/members", request.to_json, {:content_type => :json}
end
