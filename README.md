# ATS137

Olá, tudo bem?

Seja bem-vindo ao meu projeto ATS137, estou desenvolvendo este projeto no curso de Formação de Testes de Software Nível 2 Automação, da escola Iterasys com finalidade de ampliar minhas habilidades com testes automatizados utilizando o Junit5, REST Assured, Cypress, Selenium e Appium.

O projeto ainda não está completo, vou atualizando conforme eu for desenvolvendo. Fico a disposição para dúvidas e explicações sobre esse modelo.

Ferramentas e frameworks utilizados até o momento:

>  IntelliJ versão 2022.3.2
>  Junit5
>  Java JDK versão 11.0.20 
>  REST Assured versão 5.3.0

Linguagem de Programação: Java


O que já está desenvolvido:

> Criei um programa que realiza as funções básicas: somar, subtrair, multiplicar e dividir de uma Calculadora Padrão.
O código Calculadora.java está disponível no seguinte caminho:

ATS137/src/main/java/br/com/iterasys/


> Para validar meu programa Calculadora, fiz os seguintes testes de unidade :

testeSomarDoisNumeros
testeSomarDoisNumerosLendoLista
testeSomarDoisNumerosLendoArquivo (csv)
testeSubtrairDoisNumeros
testeMultiplicarDoisNumeros
testeDividirDoisNumeros
testeDividirDoisNumerosInteiros (Teste de Divisão Informando que não pode ser dividido por zero)

O código referente aos testes unitários está no seguinte caminho:

ATS137/src/test/java/unitTest/TesteCalculadora.java 

Para desenvolver o testeSomarDoisNumerosLendoArquivo (csv), disponibilizei o arquivo massaSomar.csv que está no seguinte caminho:

ATS137/src/test/resources/unitTest/csv


> Fiz automação TestUser.java para os testes da API Petstore.
Endereço do Swagger: https://petstore.swagger.io/

Automação:

POST -	 testarIncluirUsuário 
GET -	   testarConsultarUsuario 
PUT - 	 testarAlterarUsuario
DELETE - testarExcluirUsuario
GET -	   testarLogin (Gerar o token e extrair da resposta apenas o numero do token)
POST -	 testarIncluirUsuarioCSV (adicionei os usuários utilizando massa de teste)

O código referente a automação está no seguinte caminho:

ATS137/src/test/java/apiTest/TesteUser.java

Para adicionar os usuários utilizando massa de teste, criei 2 arquivos:

1º massaUser.csv que está disponível no caminho: ATS137/src/test/resources/apiTest/csv
2º User.java que está no caminho: ATS137/src/test/java/apiTest


> Para baixar as bilbiotecas necessárias utilizei o maven.compiler versão 11
Bibliotecas baixadas:

junit-jupiter-api 		  versão: 5.9.2
junit-jupiter-engine		versão: 5.9.2
junit-jupiter-params		versão: 5.9.2
gson			              versão:2.9.0
hamcrest		          	versão: 2.2


