Feature: Add Customer By Api

  Scenario: Create Customer with valid data
    Given User is not existed on system
    When I submit valid request body and valid access token
    Then Create Customer successfully

  Scenario: Create Customer with invalid data
    Given User is existed on system
    When I submit invalid request body and valid access token
    Then Can't create customer
