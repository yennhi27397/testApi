Feature: Admin Login Page

  Scenario: User log in successfully with valid username and password
    Given Account has been successfully registered
    When Enter valid username and password
    Then User login successfully


  Scenario: User can not log in successfully with blank username and valid password
    Given The account has been successfully registered
    When Enter blank username and valid password
    Then User can not login successfully