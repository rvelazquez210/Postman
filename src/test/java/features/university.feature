Feature: llamada GET a universidades
  
  Scenario: encontrar la universidad
    Given hago una llamada GET al endpoint
    When envio el request 
    And el status code es docientos
    Then me trae la universidad Brandman University

