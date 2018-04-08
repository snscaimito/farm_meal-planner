require 'rest_client'
require 'json'

BASE_URL = "http://localhost:8080/recipes"

resource = RestClient::Resource.new("#{BASE_URL}/", :user => 'user@caimito.net', :password => 'password', :headers => { :content_type => :json } )

resource.put(
  { 
    :name => 'Pancakes', 
    :description => 'Pancake base recipe', 
    :yield => '4 people',
    :ingredients => [
          { "name": "Eggs", "quantity": 3, "unit": "pcs" },
          { "name": "Flour", "quantity": 400, "unit": "gram" },
          { "name": "Milk", "quantity": 700, "unit": "ml" } 
       ],
    :instructions => 'Mix everything together' 
    }.to_json)

resource.put( 
  { 
    :name => 'Carribean beef with onions and tomatoes', 
    :description => 'Quick recipe for beef', 
    :yield => '3 people',
    :ingredients => [
          { "name": "Tomatoes", "quantity": 2, "unit": "pcs" },
          { "name": "Onions", "quantity": 2, "unit": "pcs" },
          { "name": "Beef", "quantity": 500, "unit": "gram" } 
       ],
    :instructions => 'Mix everything together' 
    }.to_json)

resource.put( 
  { 
    :name => 'White rice', 
    :description => 'Basic white rice', 
    :yield => '3 people',
    :ingredients => [
          { "name": "Rice", "quantity": 200, "unit": "gram" },
          { "name": "Water", "quantity": 200, "unit": "ml" },
          { "name": "Salt", "quantity": 1, "unit": "tablespoon" } 
       ],
    :instructions => 'Mix everything together' 
    }.to_json)

resource.put( 
  { 
    :name => 'Afrikanisches Huhn', 
    :description => 'Ein farbenfroher Gruß aus Afrika oder auch der Karibik. Eine tolle Farbkombination macht Fernweh und steigert den Hunger. Guten Appetit!', 
    :yield => '3 people',
    :ingredients => [
          { "name": "Hähnchenbrustfilet", "quantity": 400, "unit": "gram" },
          { "name": "Chilischote", "quantity": 1, "unit": "pcs" },
          { "name": "Knoblauch", "quantity": 2, "unit": "Zehe" },
          { "name": "Zwiebel", "quantity": 1, "unit": "pcs" },
          { "name": "Paprikaschote (rot)", "quantity": 1, "unit": "pcs" },
          { "name": "Orangensaft", "quantity": 200, "unit": "ml" }, 
          { "name": "Kokosmilch", "quantity": 1, "unit": "Dose" },
          { "name": "Sojasauce", "quantity": 5, "unit": "EL" },
          { "name": "Sahne", "quantity": 1, "unit": "Becher" },
          { "name": "Salz und Pfeffer", "quantity": 0, "unit": "" },
          { "name": "Currypulver", "quantity": 0, "unit": "" },
          { "name": "Öl", "quantity": 0, "unit": "" },
          { "name": "Paprikapulver, edelsüß", "quantity": 0, "unit": "" }
    ],
    :instructions => 'Aus dem Orangensaft, der Sojasoße und den Knoblauchzehen eine Marinade herstellen und die in Streifen geschnittenen Hähnchenfilets ca. 2 Stunden marinieren.
    
    Die Zwiebel und die Paprikaschote klein schneiden, die zweite Knoblauchzehe hacken, die Chilis entkernen und klein hacken. 
    
    Das Fleisch aus der Marinade nehmen und abtropfen lassen (Marinade aufheben!), mit etwas Salz, viel süßem Paprika und etwas Curry würzen. 
    
    Zwiebeln, Knoblauch und Fleisch in etwas Öl anbraten. Chilis und Paprikastreifen hinzufügen, mit der Marinade, der halben Dose Kokosmilch sowie einem Schuss Sahne ablöschen. Einige Minuten köcheln lassen bis das Fleisch gar ist. Mit den Gewürzen, Sahne und Kokosmilch abschmecken und die Soße bei Bedarf binden.' 
    }.to_json)

   