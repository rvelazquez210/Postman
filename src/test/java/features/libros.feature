@test
Feature: Buscar libros

@testgettodos
Scenario: Llamada al metodo GET que trae todos los libros
	Given hago una llamada GET al endpoint /libros
	When la respuesta es devuelta el status code es 200
	Then me trae todos los user existentes

@testgetunico
Scenario: Llamada al metodo GET que trae un solo libro
	Given hago una llamada GET al endpoint /libros/nombre_libro
	When la respuesta es devuelta el status code es docientos
	Then me trae el libro especificado