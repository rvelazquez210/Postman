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
  "name": "LLamada al metodo PUT que actualiza un registro",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@put"
    }
  ]
});
formatter.step({
  "name": "hago una llamada PUT al endpoint /libros/nombre_libro",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.PUTStepsAltualizarLibro.hago_una_llamada_PUT_al_endpoint_libros_nombre_libro()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "actualizo las keys nombre_libro y total_pagos",
  "keyword": "When "
});
formatter.match({
  "location": "step_definitions.PUTStepsAltualizarLibro.actualizo_las_keys_nombre_libro_y_total_pagos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el status code devuelto es dociento",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.PUTStepsAltualizarLibro.el_status_code_devuelto_es_dociento()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se actualiza el registro",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.PUTStepsAltualizarLibro.se_actualiza_el_registro()"
});
formatter.result({
  "status": "passed"
});
});