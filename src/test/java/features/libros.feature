@test
Feature: Buscar libros

@getall
Scenario: Llamada al metodo GET que trae todos los libros
	Given hago una llamada GET al endpoint /libros
	When la respuesta es devuelta el status code es 200
	Then me trae todos los user existentes

@get
Scenario: Llamada al metodo GET que trae un solo libro
	Given hago una llamada GET al endpoint /libros/nombre_libro
	When la respuesta es devuelta el status code es docientos
	Then me trae el libro especificado

@post
Scenario: Llamada al metodo POST que crea un registro
	Given hago una llamada POST al endpoint /libros
	When envio el json con el nuevo registro
	And la respuesta es status code docientos
	Then verifica que se creo el registro con exito
	
@delete
Scenario: Llama al metodo DELETE que elimina un registro
	Given hago una llamada DELETE al endpoint /libors
	When la respuesta envia status code es docientos
	Then se elimina el registro
	