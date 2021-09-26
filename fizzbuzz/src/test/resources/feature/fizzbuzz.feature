Feature: compute the fizzbuzz

  Scenario: With all required fields
    When user wants to compute the fizzbuzz with the following attributes
      | firstWord | secondWord | firstNumber | secondNumber | limit |
      | fizz      | buzz       | 3           | 5            | 15    |
    Then the server should handle it and the status code is 200
    And the response should with the following result
      | 1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz |


  Scenario: With invalid firstNumber
    When user wants to compute the fizzbuzz with the following attributes
      | firstWord | secondWord | firstNumber | secondNumber | limit |
      | fizz      | buzz       | -3          | 5            | 15    |
    Then the server should handle it and the status code is 400

  Scenario: With invalid secondNumber
    When user wants to compute the fizzbuzz with the following attributes
      | firstWord | secondWord | firstNumber | secondNumber | limit |
      | fizz      | buzz       | 3           | -5           | 15    |
    Then the server should handle it and the status code is 400

  Scenario: With invalid firstWord
    When user wants to compute the fizzbuzz with the following attributes
      | firstWord | secondWord | firstNumber | secondNumber | limit |
      |           | buzz       | -3          | 5            | 15    |
    Then the server should handle it and the status code is 400

  Scenario: With invalid secondWord
    When user wants to compute the fizzbuzz with the following attributes
      | firstWord | secondWord | firstNumber | secondNumber | limit |
      | fizz      |            | -3          | 5            | 15    |
    Then the server should handle it and the status code is 400