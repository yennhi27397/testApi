Feature: Admin Login Page

  Scenario: User log in successfully with valid username and password
    Given Account has been successfully registered
    When Enter valid username and password
    Then User login successfully


  Scenario Outline: User can not log in successfully as <username> and as <password>
    Given The account has been successfully registered
    When Enter as "<username>" and as "<password>"
    Then User can not login successfully
    Examples:
      | username | password |
      | A | 123456789 |
      | Admin |  |
      | Admin123 | 123456789 |

