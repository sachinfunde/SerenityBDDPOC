Feature: Test Wizink Message Mock APIS

  #Scenario: Create message by ID
    #When I hit the endpoint for createMessage1
    #Then the resulting response should contains body and subject1
#
  #Scenario: Delete message by ID
    #When I hit the endpoint for deleteMessage1
    #Then the resulting response should see the message as Message deleted successfully1

  #Scenario: Test get message by ID
    #When I hit the endpoint for getMessageByID1
    #Then the resulting response should contains messageId and subject1
#####################################################################################
#
#Negative test cases for create message. 

  #Scenario: Create message by ID with wrong header
    #When I hit the endpoint for createMessage with wrong header
    #Then the resulting response should contains status code as 400

  #Scenario: Create message by ID without passing authToken
    #When I hit the endpoint for createMessage without passing authToken
    #Then the resulting response should contains status code as 401

  #Scenario: Create message by ID by passing wrongUrl
    #When I hit the endpoint for createMessage by passing wrongUrl
    #Then the resulting response should contains status code as 404

  #Scenario: Create message by ID by passing wrong auth taken
    #When I hit the endpoint for createMessage by passing wrong auth taken
    #Then the resulting response should contains status code as 403
#
#############################################################################################
 #
  #Negative test cases for delete message.
  #
  #Scenario: Delete message by ID with wrong header
    #When I hit the endpoint for deleteMessage with wrong header
    #Then the resulting response should contains status code as 400
#
  #Scenario: Delete message by ID without passing authToken
    #When I hit the endpoint for deleteMessage without passing authToken
    #Then the resulting response should contains status code as 401
#
  #Scenario: Delete message by ID by passing wrongUrl
    #When I hit the endpoint for deleteMessage by passing wrongUrl
    #Then the resulting response should contains status code as 404
#
  #Scenario: Delete message by ID by passing wrong auth taken
    #When I hit the endpoint for deleteMessage by passing wrong auth taken
    #Then the resulting response should contains status code as 403
    
################################################################################################
#
 #
  #Negative test cases for get message.
  #
  #Scenario: Get message by ID with wrong header
    #When I hit the endpoint for getMessage with wrong header
    #Then the resulting response should contains status code as 400

  #Scenario: Get message by ID without passing authToken
    #When I hit the endpoint for getMessage without passing authToken
    #Then the resulting response should contains status code as 401

  #Scenario: Get message by ID by passing wrongUrl
    #When I hit the endpoint for getMessage by passing wrongUrl
    #Then the resulting response should contains status code as 404

  #Scenario: Get message by ID by passing wrong auth taken
    #When I hit the endpoint for getMessage by passing wrong auth taken
    #Then the resulting response should contains status code as 403
    #
########################################################################################################
 #
