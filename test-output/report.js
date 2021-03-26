$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/university.feature");
formatter.feature({
  "name": "llamada GET a universidades",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "name": "encontrar la universidad",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@test1"
    }
  ]
});
formatter.step({
  "name": "hago una llamada GET al endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.GetStepsUniversity.hago_una_llamada_GET_al_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio el request",
  "keyword": "When "
});
formatter.match({
  "location": "step_definitions.GetStepsUniversity.envio_el_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "el status code es docientos",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.GetStepsUniversity.el_status_code_es_docientos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "me trae la universidad Brandman University",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.GetStepsUniversity.me_trae_la_universidad_Brandman_University()"
});
formatter.result({
  "status": "passed"
});
});