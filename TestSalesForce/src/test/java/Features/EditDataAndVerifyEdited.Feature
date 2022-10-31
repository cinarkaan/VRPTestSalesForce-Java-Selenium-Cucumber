Feature: Created Account will be edited and then verified

  """
  In this feature , the user will be logged and then it will be verified than the has been edited
  """

  Scenario:
    Given : The User will be logged in
    When  : Account will be got
    And : Data will be "KaanC" edited
    And : Edited data will be verified
