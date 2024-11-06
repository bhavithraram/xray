Feature: Login functionality

  Scenario: Login without providing username and password
    Given User is on the login page
    When User does not enter any credentials
    And clicks on the login button
    Then User should see an error message "Empty username/password."

Scenario: Login with valid credentials
  Given User is on the login page
  When User enters valid username and valid password
  And clicks on the login button
  Then User should be navigated to the next page

