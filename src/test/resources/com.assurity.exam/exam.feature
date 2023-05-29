Feature: Technical assignment

  Scenario Outline: Using the API provided, create an automated test with the listed acceptance criteria
    Given I have a category with an ID of <category_id>
    When I query for the details of <category_id>
    Then I should see the category "<category_name>"
    And the category canRelist status is <relist_status>
    And the category should have a promotions name of <promotion_name> with text description of "<promotion_description>"
    Examples:
      | category_id | category_name | relist_status | promotion_name | promotion_description       |
      | 6329        | Home & garden | true          | Feature        | Better position in category |