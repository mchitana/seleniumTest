Feature: Create Bitlinks

  Background: User generates token for Authorisation
    Given I am an authorized bitly user

  Scenario: create a bitlink given a long url
    Given a valid long_url
    When user makes a request to create a bitlink
    Then the bitlink is created

  Scenario: create a bitlink when missing the long url
    Given an empty long_url
    When user makes a request to create a bitlink
    Then the bitlink is not created
    Then  the http response code is 400 with an error message

  Scenario: create a bitlink having the wrong domain name
    Given an unknown domain name
    When user makes a request to create a bitlink
    Then the bitlink is not created
    And the http response code is 400 with an error message


