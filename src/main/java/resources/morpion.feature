Feature: morpion
  Scenario: //description
    Given The grid contains "X" at "A"
    And The grid contains "X" at "B"
    And The grid contains "O" at "D"
    When Player "O" plays
    Then He take place at "C"


  Scenario://description
    Given The grid contains "X" at "A"
    And The grid contains "X" at "B"
    And The grid contains "O" at "I"
    And The grid contains "O" at "J"
    When Player "O" plays
    Then He take place at "H"

  Scenario: //description
    Given The grid contains "X" at "A"
    And The grid contains "X" at "D"
    And The grid contains "O" at "I"
    And The grid contains "O" at "H"
    When Player "O" plays
    Then He take place at "G"

  Scenario: //description
    Given The grid contains "X" at "D"
    And The grid contains "X" at "F"
    And The grid contains "O" at "I"
    When Player "O" plays
    Then He take place at "E"
    