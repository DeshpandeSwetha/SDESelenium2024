Feature: Validate the work flow of Agile Travel

Background:
Given Browser is launched
  
  @tag1
  Scenario: Validate agile travel site
    Given User is on Agile Travel website
    And User enters username and password
    And User clicks on remember checkbox me
    Then user clicks on sign in button
    Then User is on select flight page
    When User clicks on trip type
    Then User clicks on continue button
    Then User is on passenger page
    And User enters first name and last name
    Then User clicks on next button
    Then user is on payment page
    When card type is selected
    And user enters card number
    And user selects expiry date
    And user clicks on pay now button
    Then display confirmation message
    Then user clicks on sign off link