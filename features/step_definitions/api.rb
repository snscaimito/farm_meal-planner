def last_json
  @json_from_call
end

When("the endpoint {string} is called with:") do |url, request|
  @json_from_call = RestClient.post("#{BASE_URL}#{url}", request.to_json, {:content_type => :json})
end

When("a new element is posted to the collection {string}:") do |resourceURL, content|
  @rest_response = RestClient.put("#{BASE_URL}#{resourceURL}", content, {:content_type => :json})
end

Then("the location of the new element is returned") do
  expect(@rest_response.code).to be 201
  expect(@rest_response.headers[:location]).to include(BASE_URL)
end

When("the element is requested") do
  location = @rest_response.headers[:location]
  @rest_response = RestClient.get location, {accept: :json}
end

When("the element at {string} is retrieved") do |resourceURL|
  begin
    @rest_response = RestClient.get "#{BASE_URL}#{resourceURL}", {accept: :json}
  rescue RestClient::ExceptionWithResponse => e
    @rest_response = e.response
  end
end

Then("the element is not found") do
  expect(@rest_response.code).to be 404
end

Then("the JSON returned is:") do |json|
  json_response =  JSON.parse(@rest_response.body)
  expect(json_response).to include_json(JSON.parse(json))
end

When("the collection {string} is retrieved") do |resourceURL|
  step "the element at '#{resourceURL}' is retrieved"
end

Then("the JSON collection contains:") do |json|
  json_response =  JSON.parse(@rest_response.body)
  expect(json_response).to match_unordered_json(JSON.parse(json))
end
