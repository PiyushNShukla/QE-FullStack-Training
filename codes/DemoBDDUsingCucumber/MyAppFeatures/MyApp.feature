Feature: Login functionality

Scenario: Login with valid credentials

Given User in Login Page

When User enters "<username>" and "<password>"

And User clicks login button

Then User lands on Welcome Page


Examples: 

|				username				|				password		|
|				student				    |			Password123		    |
|			    student1				|			admin		     	|
|			    student12				|			wrongPassword		|



