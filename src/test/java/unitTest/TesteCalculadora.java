package unitTest;

// Bibliotecas
import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe

public class TesteCalculadora {
    // Atributos

    // Funções e Métodos

    // TESTE SIMPLES DE SOMAR 2 NUMEROS
    @Test
    public void testeSomarDoisNumeros(){

        // Configura
         //Valores de Entrada
        double num1 = 7;
        double num2 = 5;

        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
       double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

       // Valida - Checar
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    // Este é um teste de unidade data driven - direcionado por dados
    // TESTE LENDO LISTA
    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado){

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // Valida - Checar
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    // TESTE LENDO ARQUIVO CSV
    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado){

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // Valida - Checar
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }


     // TESTE SUBTRAIR 2 NUMEROS
    public void testeSubtrairDoisNumeros(){

        // Configura
        //Valores de Entrada
        double num1 = 7;
        double num2 = 5;

        // Valores de saída
        double resultadoEsperado = 2;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        // Valida - Checar
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    // TESTE MULTIPLICAR 2 NUMEROS
    @Test
    public void testeMultiplicarDoisNumeros(){

        // Configura
        //Valores de Entrada
        double num1 = 2;
        double num2 = 2;

        // Valores de saída
        double resultadoEsperado = 4;

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        // Valida - Checar
        assertEquals(resultadoEsperado, resultadoAtual);
    }

    // TESTE SIMPLES DE DIVISAO
   @Test
   public void testeDividirDoisNumeros(){

      double num1 = 10;
      double num2 = 4;
      double resultadoEsperado = 2.5;

      double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

      assertEquals(resultadoEsperado, resultadoAtual);
    }

    // TESTE DE DIVISAO INFORMANDO QUE NAO PODE SER DIVIDIDO POR ZERO
   @Test
   public void testeDividirDoisNumerosInteiros(){ // início do teste dividir inteiro

        int numA = 8;
        int numB = 0;
        String resultadoEsperado = "Não é possível dividir por zero";

        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.print("O resultado esperado: " + resultadoEsperado);

   } // fim dos teste dividir inteiro

}
