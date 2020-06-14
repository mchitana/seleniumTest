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
    And  the http response code is 400 with an error message INVALID_ARG_LONG_URL

  Scenario: create a bitlink having the wrong domain name
    And an unknown domain name
    When user makes a request to create a bitlink
    Then the bitlink is not created
    And the http response code is 400 with an error message INVALID_ARG_DOMAIN

    #this scenario fails s the long_url is encoded which according to the documentation is a valid inpu
  Scenario: create a bitlink sending an encoded long url
    Given an encoded long_url
    When user makes a request to create a bitlink
    Then the bitlink is created

  Scenario: create a bitlink having the wrong json payload format
    And user makes a request to create a bitlink with a malformed payload
    Then the http response code is 422 with an error message UNPROCESSABLE_ENTITY


