Feature: Demo OSB Service Charge information exchange


  Scenario: Looking for OSB service information
    When I hit the endpoint with valid account number
    Then the resulting response should contains account number related details, currency data and OSB exchange information

