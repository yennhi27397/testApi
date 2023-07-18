Feature: Add Customer Withdraw by Api

  Scenario: Add customer withdraw with valid ID customer
    Given Customer ID does not exist
    When I submit valid withdraw request body and valid access token
    Then  Customer withdraw successfully


  Scenario: Add customer withdraw with the account insufficient fund
    Given Customer ID existed
    When I submit invalid request body and valid access token
    Then  Customer can not withdraw
