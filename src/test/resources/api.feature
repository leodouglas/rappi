Feature: Cube Api tests

  Scenario Outline: creating a cube
    Given the url /api/v1/cube
    And with the parameter size with the value <size>
    When make a POST
    Then the response status must be <status>
    Examples:
      | size | status   |
      | null | 400      |
      | -1   | 400      |
      | 0    | 200      |
      |      | 400      |
      | as   | 400      |
      | 4    | 200      |

  Scenario Outline: update value in the cube
    Given the url /api/v1/cube
    And with the parameter x with the value <x>
    And with the parameter y with the value <y>
    And with the parameter z with the value <z>
    And with the parameter value with the value <value>
    When make a PUT
    Then the response status must be <status>
    Examples:
      | x    | y    | z    | value    | status |
      | -1   | -1   | -1   | 1        | 400    |
      | null | 1    | 1    | 1        | 400    |
      | 1    |      | 1    | 1        | 400    |
      | 1    | 1    | 0    | 1        | 400    |
      | 2    | 2    | 2    | null     | 400    |
      | 2    | 2    | 2    |          | 400    |
      | 2    | 2    | 2    | -4       | 200    |
      | 2    | 2    | 2    | 4        | 200    |


  Scenario Outline: update value in the cube
    Given the url /api/v1/cube
    And with the parameter x1 with the value <x1>
    And with the parameter y1 with the value <y1>
    And with the parameter z1 with the value <z1>
    And with the parameter x2 with the value <x2>
    And with the parameter y2 with the value <y2>
    And with the parameter z2 with the value <z2>
    When make a GET
    Then the response status must be <status>
    And the response json property sum must be <sum>
    Examples:
      | x1    | y1    | z1    | x2    | y2    | z2    | status | sum    |
      | -1    | 1     | 1     | 3     | 3     | 3     | 400    |        |
      | null  | 1     | 1     | 3     | 3     | 3     | 400    |        |
      | 0     | 1     | 1     | 3     | 3     | 3     | 400    |        |
      | 1     | 1     | 1     | 3     | 3     | 3     | 200    | 4      |