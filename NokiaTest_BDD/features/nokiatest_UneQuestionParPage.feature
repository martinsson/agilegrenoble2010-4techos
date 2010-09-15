Feature:
  Afin de faciliter la saisie du test Nokia
  En tant qu'utilisateur
  je veux répondre à une seule question à la fois


  Background:
    Given le test Nokia #9 pages au total

  Scenario Outline: affichage du bouton suivant
    Given je suis sur la page <page courante>
    Then je vois un bouton "Suivant" sur cette page

  Examples:

    | page courante |
    | 1             |
    | 2             |
    | 8             |


  Scenario: affichage du bouton terminé
    Given je suis sur la dernière page
    Then je vois un bouton "Terminé" sur cette page


  Scenario Outline: le bouton s'affiche uniquement quand une réponse est donnée à la question
    Given je suis sur la <page courante>
    And la réponse n'est pas donnéee
    And le bouton <bouton> n'est pas actif
    When la réponse est donnée
    Then le bouton <bouton> est actif

  Examples:
    | page courante | bouton  |
    | 1             | Suivant |
    | 2             | Suivant |
    | 9             | Terminé |


  Scenario Outline: passage à la question suivante
    Given je suis sur la page <page courante>
    When je clique sur le bouton "Suivant"
    Then je suis sur la page <page suivante>

  Examples:
    | page courante | page suivante |
    | 1             | 2             |
    | 2             | 3             |
    | 8             | 9             |


  Scenario: gestion de la fin du test
    Given je suis sur la dernière page
    When je clique sur le bouton "Terminé"
    Then je vois une page intitulée "Récapitulatif"
