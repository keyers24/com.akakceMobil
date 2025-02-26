Feature:Search
@Search
  Scenario: Laptop
    Given Akakce application opens
    When  Continue without signing up
    And   Search for laptop in the search bar
    And   See Products filter is applied
    And   Category selection is made
    And   The product with the highest price is selected
    Then  Go to seller button is verified
