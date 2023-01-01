Feature: Search and placing order for products

@SearchProduct
Scenario Outline: Search experience for product search in both home and offer pages
Given User is on greenkart landing page
When user search with short name <Name> and extracted actual name of the product
Then user search for same <Name> in offers page
And validate both names

Examples:
|Name		|
|Tom		|
|Beet		|
