Feature: Access resources when unauthorised

  Background: User generates token for Authorisation
    Given I am an unauthorized bitly user

  Scenario: create a bitlink given a long url but when unauthorised
    Given a valid long_url
    When user makes a request to create a bitlink
    Then the http response code is 403 with an error message FORBIDDEN

  Scenario: get bitly groups when unauthorised
    And user requests to get groups using a valid group_id
    Then the http response code is 403 with an error message FORBIDDEN

  Scenario: get sorted bitlinks  when unauthorised
    And user request links sorted by clicks for the past 1 month
    Then the http response code is 403 with an error message FORBIDDEN



