Feature: Search and placing order for products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offer pages
Given User is on greenkart landing page
When user search with short name <Name> and extracted actual name of the product
And add "3" items of the selected product to cart
Then user proceeds to checkout and validate <Name> in checkout page
And verify the promocode and placing order

Examples:
|Name		|
|Tom		|
