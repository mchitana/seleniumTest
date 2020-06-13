Feature: Create Bitlinks

  Background: User generates token for Authorisation
    Given I am an authorized bitly user

  Scenario: get sorted bitlinks by clicks when some links have been clicked in the specified period
    And user request links sorted by clicks for the past month
    Then a list of sorted links are returned

  Scenario: get sorted bitlinks by clicks when none has been clicked in the specified period
    And user request links sorted by clicks for the past minute
    Then an empty list of links is returned

  Scenario: get sorted bitlinks by with an unknown criteria
    But user request links sorted by unknown for the past month
    Then  the http response code is 400 with an error message


