require 'rubygems'
require 'rest_client'
require 'json'

request = { :name => 'Egg-Asparagus', 
  :description => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 
  :yield => '3 people' }
puts RestClient.put 'http://localhost:8080/recipe', request.to_json, {:content_type => :json}