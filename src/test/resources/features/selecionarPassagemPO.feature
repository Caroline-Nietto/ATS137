Feature: Selecionar Passagem PO
  Scenario: Selecionar Passagem com Sucesso PO
    Given que acesso o site Blazedemo PO
    When seleciono a origem como "Boston" e destino "Dublin" PO
    And clico em Procurar Voo PO
    Then exibe a frase indicando o voo entre "Boston" e "Dublin" PO