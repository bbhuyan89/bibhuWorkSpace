@login
Feature: Login Functionality test

@Logintest01
Scenario: User validate the loginpage title
Given user navigate to the portal
When user gets the title of the LoginPage
Then page title should be "Automation Exercise - Signup / Login"


@Logintest02
Scenario: User should able to login successfully
Given user navigate to the portal
And user entered the credentials to Login and Click on the login button
Then user should navigate to the Dashboard page and validate "Automation Exercise" text