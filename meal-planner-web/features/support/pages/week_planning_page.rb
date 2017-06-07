class WeekPlanningPage
  include PageObject

  text_field(:searchTerm, :id => 'searchTerm')
  button(:search, :id => 'searchForRecipe')
  unordered_list(:searchResultList, :id => 'searchResultList')
end