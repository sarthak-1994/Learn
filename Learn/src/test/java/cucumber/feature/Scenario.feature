Feature : Fetch the detail from Data table

@smoke
  Scenario: Fetch detail from data table in list

  Given User data is given in Data table
    | name 1|
    | name 2|

  When User Read data