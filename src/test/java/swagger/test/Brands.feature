Feature: Brands

  Scenario Outline: check that API successfully returns a list of brands.
    When  retrieve list of brands
    Then  retrieve brands response status code should be <code>
   Then   list of brands should have more than one entry
    And   each brand object should contains "<id>" and "<name>" properties.
    Examples:
      | code | id | name |
      | 200  | _id | name |

  Scenario Outline: check that brand is successfully returned by a specific id .
    When  retrieve brand by "<id>"
    Then   retrieve specific brand response status code should be <code>
    And    brand name should match "<brand name>"
    Examples:
      | id                        | brand name  |code|
      | 64b712dd49e85607248e29ae  | A Plus 7226 | 200|

  Scenario Outline: check that API prevents duplicate creation of brand entries
    When  create new brand record with "<name>"
    When  create new brand record with "<name>"
    Then  error message for duplicate creation should be returned in response "<error message>"
    Examples:
       | name                      | error message          |
       | A Plus 7226               | Unable to create brand |

  Scenario Outline: check that API returns an error when attempting to retrieve a brand that does not exist
    When  retrieve brand by "<id>"
    Then  retrieve specific brand response status code should be <code>
    Then  error message for when retrieve not existing a brand should be returned in response "<error message>"
    Examples:
      | id         | code | error message         |
      | 64b712dd49 | 422  | Unable to fetch brand |


  Scenario Outline: check that API throws an error when attempting to update non-existent brand.
    When  update brand "<name>" and "<description>" by it's "<id>"
    Then  update specific brand response status code should be <code>
    And   error message for when update not existing a brand should be returned in response "<error message>"
    Examples:
      | id         | code | error message           | name        | description|
      | 64b712dd4  | 422  | Unable to update brands | name        | description|


  Scenario Outline: check that API throws an error when attempting to delete non-existent brand.
    When  delete brand by it's "<id>"
    Then  delete specific brand response status code should be <code>
    And   error message for when delete not existing a brand should be returned in response "<error message>"
    Examples:
      | id         | code | error message         |
      | 64b712dd49 | 422  | Unable to delete brand|





