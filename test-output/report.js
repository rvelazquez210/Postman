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
  "name": "Llama al metodo DELETE que elimina un registro",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@delete"
    }
  ]
});
formatter.step({
  "name": "hago una llamada DELETE al endpoint /libors",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.DELETEStepsUnicoLibro.hago_una_llamada_DELETE_al_endpoint_libors()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "la respuesta envia status code es docientos",
  "keyword": "When "
});
formatter.match({
  "location": "step_definitions.DELETEStepsUnicoLibro.la_respuesta_envia_status_code_es_docientos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se elimina el registro",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.DELETEStepsUnicoLibro.se_elimina_el_registro()"
});
formatter.result({
  "status": "passed"
});
});