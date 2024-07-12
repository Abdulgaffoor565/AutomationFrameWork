Feature: The Men Menue Option Scenarios

Background: user login to the LUMA website
Given user accessing login page
When user enter valid email as "asasasasasasasas@gmail.com" and valid password as "abdul@123"
And click on Login Button
Then user is navigated to home page and title as "Home Page"

Scenario: Verify jacket page should be open when we open it through Men menue section
And Hover the mouse to Men Menue
And Hover mouse to Top and select jachet option
Then Verify the page title should be shown as "Jackets - Tops - Men"
And Close the browser

Scenario: Verify 'Hoodies & Sweatshirts' page should be open when we open it through 'Men' menue section.
And Hover the mouse to Men Menue
And Hover mouse to Top and select 'Hoodies & Sweatshirts' option
Then Verify the page title should be shown as "Hoodies & Sweatshirts - Tops - Men"
And Close the browser

Scenario: Verify 'Tees' page should be open when we open it through 'Men' menue section.
And Hover the mouse to Men Menue
And Hover mouse to Top and select 'Tees' option
Then Verify the page title should be shown as "Tees - Tops - Men"
And Close the browser

Scenario: Verify 'Tanks' page should be open when we open it through 'Men' menue section.
And Hover the mouse to Men Menue
And Hover mouse to Top and select 'Tanks' option
Then Verify the page title should be shown as "Tanks - Tops - Men"
And Close the browser

Scenario: Verify 'Pants' page should be open when we open it through 'Men' menue section.
And Hover the mouse to Men Menue
And Hover mouse to 'Bottoms' and select 'Pants' option
Then Verify the page title should be shown as "Pants - Bottoms - Men"
And Close the browser

Scenario: Verify 'Shorts' page should be open when we open it through 'Men' menue section.
And Hover the mouse to Men Menue
And Hover mouse to 'Bottoms' and select 'Shorts' option
Then Verify the page title should be shown as "Shorts - Bottoms - Men"
And Close the browser

Scenario: Open the 'Jacket' from 'Men Top' option and verify it should have 12 dropdown at the bottom of 'Shopping Options'
And Hover the mouse to Men Menue
And Hover mouse to Top and select jachet option
Then Verify inside jacket page at the bottom of Shopping Optiond "12" dropdown option should be present.
And Close the browser

Scenario: Inside 'Mens jacjket' page Open 'Style' dropdown and select 'Insulated' option and Verify the 'Style' Option should be removed.
And Hover the mouse to Men Menue
And Hover mouse to Top and select jachet option
And Click on 'Style' Dropdown.
And Click on 'Insulated' option.
Then Verify the "Style" Option Should be removed from 'Shopping Options'
And Close the browser

@smoke
Scenario: Inside 'Mens jacjket' page Open 'Style' dropdown and select 'Insulated' option and Clear All Verify all 12 Shopping Options should be present.
And Hover the mouse to Men Menue
And Hover mouse to Top and select jachet option
And Click on 'Style' Dropdown.
And Click on 'Insulated' option.
And Click on 'Clear All' Button.
Then Verify All "12" Shopping Options are present
And Close the browser.