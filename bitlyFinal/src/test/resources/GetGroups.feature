Feature: Create Bitlinks

  Background: User generates token for Authorisation
    Given I am an authorized bitly user

  Scenario: get bitly groups by a valid group_id
    And user requests to get groups using a valid group_id
    Then The group details are returned

  Scenario: get bitly groups by an invalid group_id
    And user requests to get groups using a invalid group_id
    Then The user is forbidden to retrieve the groups info

  Scenario: get bitly groups calling the wrong url
    And user requests to get groups using a invalid group_id
    Then The user is forbidden to retrieve the groups info






