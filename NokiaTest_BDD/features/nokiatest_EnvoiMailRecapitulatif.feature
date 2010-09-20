Feature:
  Afin de disposer d'une trace local de mon passage du test Nokia 
  En tant qu'utilisateur
  je veux recevoir un mail récapitulatif

  Scenario: Je demande l'envoi du récapitulatif sur mon mail
    Given je suis sur la page récapitulatif
    When je fournis mon adresse mail test.nokia@agilegrenoble.fr
    And je clique sur le bouton "Envoyer par mail"
    Then je devrais voir la confirmation de l'envoi du mail


  Scenario Outline: Les adresses mail mal formatées sont rejetées
    Given je suis sur la page récapitulatif
    When je fournis mon adresse mail <email>
    Then je devrais être averti que mon adresse n'est pas bien formatée
    And le bouton "Envoyer par mail" devrait rester inactif
  Examples:
    | email | 
    | test nokia@agilegrenoble.fr | # adresse avec un espace
    | test.nokia.agilegrenoble.fr | # adresse sans arrobase


 Scenario: Je réceptionne bien le mail récapitulatif
    Given j'ai demandé l'envoi de mon récapitulatif
    And ma boîte mail est vide
    When je consulte ma boîte mail
    Then ma boîte mail devrait contenir un mail intitulé "Récapitulatif de votre test Nokia"

