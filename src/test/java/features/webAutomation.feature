

Feature: Process Flow to Buy a Sony Vaio Laptop

Scenario: User Selects Laptops to Buy
Given User Opens Demoblaze website
When User Navigates through Product Categories Phone, Laptops and Monitors
And User Selects Laptops to Buy
Then The selected Laptops are displayed on Shopping Cart


Scenario: User Removes One Selected Laptop and Buys The Remaining One

When User Removes One Item From Cart
And User Places an Order for The Remaining Item After Filling Out The Web Form
Then Corresponding Order Placement will be Successful
