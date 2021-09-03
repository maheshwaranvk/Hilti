$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:target/test-classes/features/fireStopSubmittals.feature");
formatter.feature({
  "name": "Submittals generation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify submittal generation process",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User opens Hilti website for country \u003ccountry\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "User navigates to Firestop submittal generator page",
  "keyword": "When "
});
formatter.step({
  "name": "User starts submittal generation process",
  "keyword": "And "
});
formatter.step({
  "name": "User selects Firestop systems \u003cfireStopCount\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User creates submittal",
  "keyword": "And "
});
formatter.step({
  "name": "User deselects Firestop products \u003cdeselectCount\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User selects submittals options \u003ccoverPage\u003e \u003cpageNo\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User finalizes submittal generation process",
  "keyword": "And "
});
formatter.step({
  "name": "User can download the generated document",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "fireStopCount",
        "deselectCount",
        "coverPage",
        "pageNo",
        "country"
      ]
    },
    {
      "cells": [
        "\u00273\u0027",
        "\u00271\u0027",
        "\u0027No cover page\u0027",
        "\u0027No\u0027",
        "US"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify submittal generation process",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User opens Hilti website for country US",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.userOpensHiltiWebsite(com.hilti.ta.utils.Country)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Firestop submittal generator page",
  "keyword": "When "
});
formatter.match({
  "location": "com.hilti.ta.steps.ProductNavigationSteps.user_navigates_to_Firestop_submittal_generator_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User starts submittal generation process",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_starts_submittal_generation_process()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects Firestop systems \u00273\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_selects_Firestop_systems(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User creates submittal",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_creates_submittal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User deselects Firestop products \u00271\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_deselects_Firestop_products(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects submittals options \u0027No cover page\u0027 \u0027No\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_selects_submittals_options(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User finalizes submittal generation process",
  "keyword": "And "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_finalizes_submittal_generation_process()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can download the generated document",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hilti.ta.steps.GeneralSteps.user_can_download_the_generated_document()"
});
formatter.result({
  "status": "passed"
});
});