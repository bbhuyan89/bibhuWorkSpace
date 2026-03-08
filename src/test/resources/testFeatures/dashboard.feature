Feature: Dashboard Functionality test

@Dashboardtest01
Scenario: User should able to login successfully and validate the category options
Given user navigate to the portal
And user entered the credentials to Login and Click on the login button
Then user should navigate to the Dashboard page and validate "Automation Exercise" text
And user verify the category options
And user click on the women option under category

@WomenDressTest01
Scenario: User should navigate to Women Dress section and validate products
Given user navigate to the portal
And user entered the credentials to Login and Click on the login button
Then user should navigate to the Dashboard page and validate "Automation Exercise" text
When user click on the women category to expand
And user click on the dress section under women category
Then user should be redirected to the dress products page
And user validate the dress page title contains "Dress"
And user verify that dress products are displayed