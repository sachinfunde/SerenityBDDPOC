Feature: Demo APIs
  #Scenario: Looking for OSB service information
   # When I hit the endpoint with valid account number
    #Then the resulting response should contains account number related details, currency data and OSB exchange information

  Scenario: Verify the user information
    When I provide the userid
    Then I should get user information

  Scenario: Numbers to word conversion
    When I pass Number
    Then I should get word for it

