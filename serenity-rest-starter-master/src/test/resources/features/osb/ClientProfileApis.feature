Feature: Test Wizink Client profile data

  Scenario: Test get Contact data Spain
  When I hit the endpoint for get ContactData for Spain1
  Then the resulting response should contains Contact data for Spain1
  
  #Scenario: Test get Contact data portuguize
  #When I hit the endpoint for get ContactData for portuguze1
  #Then the resulting response should contains Contact data for portuguze1
  
  #Scenario: Test get personal data spain
  #When I hit the endpoint for get Personaldata for spain1
  #Then the resulting response should contains personal data1
  
  #Scenario: Test get personal data portuguize
  #When I hit the endpoint for get Personaldata for portuguze1
  #Then the resulting response should contains personal data for portuguze1
  
  ###############################################################################
  
  #Negative test cases for Test get Contact data Spain.
  #
  #Scenario: Test get Contact data Spain with wrong header
    #When I hit the endpoint for get Contact data Spain with wrong header
    #Then the resulting response should contains status code as 400
#
  #Scenario: Test get Contact data Spain without passing authToken
    #When I hit the endpoint for get Contact data Spain without passing authToken
    #Then the resulting response should contains status code as 401

  #Scenario: Test get Contact data Spain by ID by passing wrongUrl
    #When I hit the endpoint for Test get Contact data Spain by passing wrongUrl
    #Then the resulting response should contains status code as 404
#
  #Scenario: Test get Contact data Spain by passing wrong auth taken
    #When I hit the endpoint for Test get Contact data Spain by passing wrong auth taken
    #Then the resulting response should contains status code as 403

  ######################################################################################
  
  #Negative Test cases for Test get Contact data portuguize
  
  #Scenario: Test get Contact data portuguize with wrong header
    #When I hit the endpoint for get Contact data portuguize with wrong header
    #Then the resulting response should contains status code as 400

  #Scenario: Test get Contact data portuguize without passing authToken
    #When I hit the endpoint for get Contact data portuguize without passing authToken
    #Then the resulting response should contains status code as 401
#
  #Scenario: Test get Contact data portuguize by ID by passing wrongUrl
    #When I hit the endpoint for Test get Contact data portuguize by passing wrongUrl
    #Then the resulting response should contains status code as 404
#
  #Scenario: Test get Contact data portuguize by passing wrong auth taken
    #When I hit the endpoint for Test get Contact data portuguize by passing wrong auth taken
    #Then the resulting response should contains status code as 403
    
  ################################################################################################
  
  #Negative Test cases for Test get Personal data spain
  
   #Scenario: Test get Personal data Spain with wrong header
    #When I hit the endpoint for get Personal data Spain with wrong header
    #Then the resulting response should contains status code as 400
#
  #Scenario: Test get Personal data Spain without passing authToken
    #When I hit the endpoint for get Personal data Spain without passing authToken
    #Then the resulting response should contains status code as 401
#
  #Scenario: Test get Personal data Spain by ID by passing wrongUrl
    #When I hit the endpoint for Test get Personal data Spain by passing wrongUrl
    #Then the resulting response should contains status code as 404
#
  #Scenario: Test get Personal data Spain by passing wrong auth taken
    #When I hit the endpoint for Test get Personal data Spain by passing wrong auth taken
    #Then the resulting response should contains status code as 403
    
 ################################################################################################
  
  #Negative Test cases for Test get Personal data portuguize
  
  #Scenario: Test get Personal data portuguize with wrong header
    #When I hit the endpoint for get Personal data portuguize with wrong header
    #Then the resulting response should contains status code as 400
#
  #Scenario: Test get Personal data portuguize without passing authToken
    #When I hit the endpoint for get Personal data portuguize without passing authToken
#
  #Scenario: Test get Personal data portuguize by ID by passing wrongUrl
    #When I hit the endpoint for Test get Personal data portuguize by passing wrongUrl
    #Then the resulting response should contains status code as 404
#
  #Scenario: Test get Personal data portuguize by passing wrong auth taken
    #When I hit the endpoint for Test get Personal data portuguize by passing wrong auth taken
    #Then the resulting response should contains status code as 403
    
 ##########################################################################################################