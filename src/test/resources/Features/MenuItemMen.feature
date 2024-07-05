Feature: The Men Menue Option Scenarios

Background: user login to the LUMA website
Given user accessing login page
When user enter valid username and valid password
And click on Signin Button
Then user is navigated to home page

Scenario: Verify jacket page should be open when we open it through Men menue section
And Hover the mouse to Men Menue
And Hover mouse to Top and select jachet option
Then Verify the page title should be shown as "Jackets - Tops - Men"