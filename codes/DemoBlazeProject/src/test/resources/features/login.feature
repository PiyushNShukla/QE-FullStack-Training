Feature: Login Functionality

Scenario: Login with valid username and valid password

Given User is on the home page and clicks on Login
When User enters valid username "admin"
And User enters valid password "admin"
And User clicks on the Login button 
Then User should be logged in successfully

Scenario: Login with invalid username and valid password

Given User is on the home page and clicks on Login
When User enters invalid username "itisawrongusername"
And User enters valid password "admin"
And User clicks on the Login button 
Then alert message "User does not exist." should be displayed

Scenario: Login with valid username and invalid password

Given User is on the home page and clicks on Login
When User enters valid username "admin"
And User enters invalid password "incorrectAdmin"
And User clicks on the Login button 
Then alert message "Wrong password." should be displayed


Scenario: Login with empty credentials

Given User is on the home page and clicks on Login
When User clicks on the Login button 
Then alert message "Please fill out Username and Password." should be displayed
 
