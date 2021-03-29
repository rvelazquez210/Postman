$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/libros.feature");
formatter.feature({
  "name": "Buscar libros",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "name": "Llamada al metodo GET que trae todos los libros",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@testgettodos"
    }
  ]
});
formatter.step({
  "name": "hago una llamada GET al endpoint /libros",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.GETStepsTodosLibros.hago_una_llamada_GET_al_endpoint_libros()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "la respuesta es devuelta el status code es 200",
  "keyword": "When "
});
formatter.match({
  "location": "step_definitions.GETStepsTodosLibros.la_respuesta_es_devuelta_el_status_code_es()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me trae todos los user existentes",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.GETStepsTodosLibros.me_trae_todos_los_user_existentes()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Llamada al metodo GET que trae un solo libro",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@testgetunico"
    }
  ]
});
formatter.step({
  "name": "hago una llamada GET al endpoint /libros/nombre_libro",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.GETStepsUnicoLibro.hago_una_llamada_GET_al_endpoint_libros()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "la respuesta es devuelta el status code es docientos",
  "keyword": "When "
});
formatter.match({
  "location": "step_definitions.GETStepsUnicoLibro.la_respuesta_es_devuelta_el_status_code_es()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me trae el libro especificado",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.GETStepsUnicoLibro.me_trae_el_libro_especificado()"
});
formatter.result({
  "status": "passed"
});
});