Feature: Search
 Scenario Outline: Verify search functionality for country <country>
 Given User opens Hilti website for country <country>
 When User navigates to search page for search term <searchTerm>
 Then User can see product results in the search page
 When User selects technical documents tab
 Then User can see technical document results in the search page
 When User selects videos tab
 Then User can see video results in the search page
 When User selects editorials tab
 Then User can see editorial results in the search page
 
 
 Examples:
 |country|searchTerm|
 |US|'Cordless'|
 |DE|'Bohrhammer'|
