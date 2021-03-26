@tag
Feature: llamada GET a universidades
  

  @tag2
  Scenario: encontrar la universidad
    Given hago una llamada GET al endpoint /search?country=United+States
    When envio el request 
    And el status code es docientos
    Then me trae la universidad Brandman University

