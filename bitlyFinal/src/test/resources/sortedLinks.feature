Feature: Get Sorted Bitlinks

  Background: User generates token for Authorisation
    Given I am an authorized bitly user

  Scenario: get sorted bitlinks by clicks when some links have been clicked in the specified period
    And user request links sorted by clicks for the past 2 months
    Then a list of sorted links are returned

  Scenario: get sorted bitlinks by clicks when none has been clicked in the specified period
    And user request links sorted by clicks for the past 1 minute
    Then an empty list of links is returned

  Scenario: get sorted bitlinks by clicks but in undefined time period
    And user request links sorted by clicks for the past 1 year
    Then  the http response code is 400 with an error message INVALID_ARG_UNIT

  Scenario: get sorted bitlinks by an unknown sort criteria
    And user request links sorted by unknown for the past 2 months
    Then  the http response code is 400 with an error message INVALID_ARG_SORT


