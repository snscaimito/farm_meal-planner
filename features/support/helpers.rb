def clear_members
  # for now do nothing until Spring Security has been used properly
#  RestClient.delete "#{BASE_URL}/members"
end

def clear_recipes
  url = SINGLE_APP ? "#{BASE_URL}" : "#{BASE_URL}/recipes"
  begin
    RestClient.delete url
  rescue RestClient::ExceptionWithResponse => e
    e.response
  end
end

def create_egg_asparagus_recipe
  request = { :name => 'Egg-Asparagus', 
    :description => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 
    :yield => '3 people',
    :ingredients => [
          { "name": "Eggs", "quantity": 3, "unit": "pcs" },
          { "name": "Asparagus", "quantity": 400, "unit": "gram" },
          { "name": "Bacon", "quantity": 100, "unit": "gram" } 
       ] }
  RestClient.put "#{BASE_URL}/api/recipes", request.to_json, {:content_type => :json}
end

def create_pancakes_recipe
  request = { :name => 'Pancakes', 
    :description => 'Pancake base recipe', 
    :yield => '4 people',
    :ingredients => [
          { "name": "Eggs", "quantity": 3, "unit": "pcs" },
          { "name": "Flour", "quantity": 400, "unit": "gram" },
          { "name": "Milk", "quantity": 700, "unit": "ml" } 
       ] }
  RestClient.put "#{BASE_URL}/api/recipes", request.to_json, {:content_type => :json}
end

def register_member_with(email, password)
  request = { :email => email, :password => password }
  RestClient.put "#{BASE_URL}/api/members", request.to_json, {:content_type => :json}
end
