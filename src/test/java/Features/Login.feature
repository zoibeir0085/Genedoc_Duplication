Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario Outline: NO EIP dependency
    Given I navigate to the login page
    And I enter "<username>" and "<password>"
    And I click login button
    Then I duplicate folder
    Then I archieve
    Then I cancel archieve
    Then I delete duplicated folder

    Then I close the browser
    Examples:
      | username        | password | Document                   | CharteGraphique        | Rédacteurs     | Approbateur    | DateDeCloture | engagement code |
      | rgauvin@kpmg.fr | aezan75  | COVID19\Justificatif KPMPG | Justificatif KPMG.docx | BELKACEM Amine | BELKACEM Amine | 31/08/2020    | 1632222         |

