Feature: Login
Scenario: Successful login with valid credentials.
Given user launch the chrome browser.
When user open URL
When user enter email "asasasasasasasas@gmail.com" and password as "abdul@123"
And click on login button
Then page title should be "[Home Page]"