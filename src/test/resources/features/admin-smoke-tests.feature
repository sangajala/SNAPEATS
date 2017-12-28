Feature: Admin smoke test features

  @admin
  Scenario: Add driver and view his details

    Given admin logged into the admin panel
    When he create a driver with username "atul1@delhi.com"
    Then driver should be successfully created
    When admin view his details
    Then the details should be as entered

  @admin1
  Scenario Outline: Add shops with details

    Given admin logged into the admin panel
    When he clicks on add shop
    When he hovers over shop button
    Then he should enter the details as with Shop Type options
    And  he should enter details as"<ShopName>" "<Address>" "<City>" "<Postcode>" "<PhoneNo>" "<ShopLatitude>" "<ShopLongitude>" "<ShopWebsite>"
    And  he upload the shop image
    Then added shop should be created successfully
    When admin view shop details
    And the details should be as entered

    Examples:
      | ShopName | Address     | City | Postcode | PhoneNo      | ShopLatitude | ShopLongitude | ShopWebsite     |
      | TeaTime  | 21fairyland | abc  | xyz123   | 123456712456 | 56.7890      | 65.9870       | www.teatime.com |


  @admin2
  Scenario Outline: Create order with order form

    Given admin logged into the admin panel
    When he clicks on create order
    And he should enter the deliver details as"<Address1>""<city>""<PostCode>""<driverName>""<orderNotes>""<shopForOrder>""<ShopAddress>""<itemCategory>""<item>""<numberOfItems>"
    Then he should view order details

    Examples:
      | Address1 | city   | PostCode | driverName | orderNotes | shopForOrder | ShopAddress                                 | itemCategory | item         | numberOfItems |
      | EastHam  | London | xyz      | abc        | test notes | Tesco        | 110-112 Baker St, Marylebone, London London| Burger       | Cheese Burger | 1             |


  @admin3
  Scenario: Add Category and view details

    Given admin logged into the admin panel
    When he clicks on categories
    And he adds category with catagory name"veg burger" and description with"veg is good"
    Then categories should be added successfully
    And admin view category details

#  @admin5
  Scenario Outline: Add item and view its details
    Given admin logged into the admin panel
    When user navigates to items page to add item
    And user enters item details as "<Category>""<Shop>""<ItemName>""<ItemPrice>""<ItemDescription>"
    Then he should view item details


    Examples:
      | Category | Shop     | ItemName | ItemPrice | ItemDescription             |
      | Sides    | Wagamama | Wedgedsed   | 17.00     | They are made from potatoes |

#  @admin5
  Scenario: Add Menu

    Given admin logged into the admin panel
    When he clicks on menu items
    And he adds menu name with"<fiterCof>"
    Then menu name should be successfully added

  @admin5
  Scenario: Add Category and view details

    Given admin logged into the admin panel
    When he clicks on categories
    And he adds category with category name "Desedrdtdst" and description "Icescream"
    Then categories should be added successfully
    And admin view category details
    Then the category details should be as entered



