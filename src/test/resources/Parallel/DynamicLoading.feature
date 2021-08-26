@dynamicLoading
Feature: Dynamic loading feature
#
#  Dynamically Loaded Page Elements
#  It's common to see an action get triggered that returns a result dynamically.
#  It does not rely on the page to reload or finish loading.
#  The page automatically gets updated (e.g. hiding elements, showing elements, updating copy, etc) through the use of JavaScript.
#
#  There are two examples.
#  One in which an element already exists on the page but it is not displayed.
#  And another where the element is not on the page and gets added in.

  Scenario:Element already exists on the page but it is not displayed -Example 1
    Given user is on the internet herokapp examples page
    When user clicks on "Dynamic Loading" from herokapp examples page
    Then The Dynamically Loaded Page Elements is displayed
    When User clicks on example one and start
    Then "Hello World!" is displayed on the Dynamically Loaded Page