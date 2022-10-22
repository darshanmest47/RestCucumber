Feature: Addition Deletion Updation of Products

  Scenario Outline: Creation of New Product
    Given User already has API to Add Product
    Then User creates testdata with "<name>" "<type>" "<price>"
    When User Hits "CREATEPRODUCT" API with "POST" request
    Then the status code received by the User is "201"
    When User Hits "GETPRODUCTBYID" with the id
    Then the details received in response are equal to "<name>" "<type>" "<price>"

    Examples:
    | name |  type   |    price   |
    | AK47  | Assault-Rifle | 50000|
    | AK56  | Assault-Midrange | 60000 |

