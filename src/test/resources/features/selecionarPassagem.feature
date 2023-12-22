##language: pt
#  Funcionalidade: Selecionar Passagem
#    Cenario: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando seleciono a origem como "São Paolo" e destino "Berlin"
#      E clico em Procurar Voo
#      Entao exibe a frase indicando o voo entre "São Paolo" e "Berlin"


Feature: Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem como "São Paolo" e destino "Berlin"
    And clico em Procurar Voo
    Then exibe a frase indicando o voo entre "São Paolo" e "Berlin"