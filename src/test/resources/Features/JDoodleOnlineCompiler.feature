Feature: JDoodle Online Java Compiler

  Scenario: Verify Page Title
    Given I navigate to the JDoodle website
    Then the page title should be "JDoodle - Online Java Compiler"

  Scenario: Compile and Execute Java Code
    Given I navigate to the JDoodle website
    When I enter Java code in the editor and click on "Run"
    Then the output should be displayed correctly

  Scenario: Switch Language to C
    Given I navigate to the JDoodle website
    When I select the "C" language from the dropdown
    Then the editor and compiler should switch to the C programming language

  Scenario: Share Code via Link
    Given I navigate to the JDoodle website
    When I enter Java code in the editor and click on "Share"
    Then I should be able to copy and load the shared code via the generated link

  Scenario: Verify Syntax Highlighting
    Given I navigate to the JDoodle website
    When I enter Java code with syntax elements in the editor
    Then syntax highlighting should be applied correctly