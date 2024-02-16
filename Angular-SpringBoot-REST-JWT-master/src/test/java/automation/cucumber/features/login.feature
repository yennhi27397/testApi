Feature: Application login

  Scenario: Home page default login
    Given User is existed on Net banking landing page
    When User login into application with valid username and password
    Then Home page is populated
    And cards are displayed
