Feature: Brands

  Scenario Outline: check that API successfully returns a list of brands.
    When  retrieve list of brands
    Then  response status code should be "<code>"
    And   list of brands should have more than one entry
    And   each brand object should contains "<id>" and "<name>" properties.
    Examples:
      | code | id | name |
      | 200  | id | name |

  Scenario Outline: check that brand is successfully returned by a specific id .
    When  retrieve brand by "<id>"
    Then  response status code should be "<code>"
    And   brand name should match "<brand name>"
    Examples:
      | id                       | code | brand name  |
      | 64b712dd49e85607248e29ae | 200  | A Plus 7226 |

  Scenario Outline: check that API prevents duplicate creation of brand entries
    When  create new brand record with "<name>" and "<description>"
    Then  response status code should be "<code>"
    When  create new brand record with "<name>" and "<description>"
    Then  error message for duplicate creation should be returned in response "<error message>"
    Examples:
      | code | name        | description | error message         |
      | 200  | A Plus 7226 | new brand   | string already exists |


  Scenario Outline: check that API returns an error when attempting to retrieve a brand that does not exist
    When  retrieve brand by "<id>"
    Then  response status code should be "<code>"
    And   error message for when retrieve not existing a brand should be returned in response "<error message>"

    Examples:
      | id         | code | error message         |
      | 64b712dd49 | 422  | Unable to fetch brand |

  Scenario Outline: check that API throws an error when attempting to update non-existent brand.
    When  update brand "<name>" and "<description>" by it's "<id>"
    Then  response status code should be "<code>"
    And   error message for when retrieve not existing a brand should be returned in response "<error message>"
    Examples:
      | id         | code | error message         | name        | description|
      | 64b712dd49 | 422  | Unable to fetch brand | name        | description|

  Scenario Outline: check that API throws an error when attempting to update non-existent brand.
    When  delete brand by it's "<id>"
    Then  response status code should be "<code>"
    And   error message for when retrieve not existing a brand should be returned in response "<error message>"
    Examples:
      | id         | code | error message         |
      | 64b712dd49 | 422  | Unable to fetch brand |



    Then  check that schema response is correct "<schemaPath>"

    Examples:
      | schemaPath  |
      | schema.json |

