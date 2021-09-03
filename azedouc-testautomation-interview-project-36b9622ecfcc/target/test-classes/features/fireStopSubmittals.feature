Feature: Submittals generation
Scenario Outline: Verify submittal generation process
Given User opens Hilti website for country <country>
When User navigates to Firestop submittal generator page
And User starts submittal generation process
And User selects Firestop systems <fireStopCount>
And User creates submittal
And User deselects Firestop products <deselectCount>
And User selects submittals options <coverPage> <pageNo>
And User finalizes submittal generation process
Then User can download the generated document

Examples:
|fireStopCount|deselectCount|coverPage|pageNo|country|
|'3'|'1'|'No cover page'|'No'|US|