//nome do pacote
package apiTest;

// Bilbiotecas

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Classe
public class TesteUser {    // inicio da classe
    // Atributos
    static String ct = "application/json";     // content type
    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // Funções e Métodos
    // Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // Funções de Teste
    @Test
    @Order(1)
    public void testarIncluirUser() throws IOException {
        // carregar os dados do nosso json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userID = "26102015";

        // realizar o teste
        given()                                         // Dado que
                .contentType(ct)    // o tipo de conteudo
                .log().all()                          // mostre tudo na requisição
                .body(jsonBody)                       // corpo da requisição
       .when()
                .post(uriUser) // Endpoint
       .then()                                      // Então
                .log().all()                        // mostra tudo no retorno
                .statusCode(200)                 // comunicação ida e volta ok, compara o codigo de fora
                .body("code", is(200))     // compara o codigo de dentro - tag code é 200
                .body("type", is("unknown")) // tag type é unknown
                .body("message", is(userID))      // message é o userId
       ;
    }  //fim do post

    @Test
    @Order(2)
    public void testarConsultarUser(){
        String username = "casnoop";  // variavel


        // resultados esperados
        int userId = 26102015;              // codigo do usuario
        String email = "snoop29@teste.com";
        String senha = "123465";
        String telefone = "11999998888";


        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
        ;

    }  // fim do get

    @Test
    @Order(3)
    public void testarAlterarUser() throws IOException {   // inicio Put User
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userID = "26102015";
        String username = "casnoop";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userID))
        ;

    }   // fim Put User

    @Test
    @Order(4)
    public void testarExlcuirUser(){   // inicio Delete User

        String username = "casnoop";

        given()
                .log().all()
                .contentType(ct)
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;

    }   // fim Delete User

    @Test
    public void testarLogin(){  // Inicio Get gerando Token

        String username = "casnoop";
        String password = "123";

        Response response = (Response) given()
                .log().all()
                .contentType(ct)
        .when()
                .get(uriUser + "login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
        .extract()
        ;

        // Extração do token da resposta
        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteudo do Token: " + token);
        ;

    }   // Fim do Get com Token


    // Utilizando MASSA DE TESTE
    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
    public void testarIncluirUserCSV(
            String id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            String userStatus)
    {

        User user = new User(); // instancia a classe User

        user.id = id;
        user.username = username;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

       Gson gson = new Gson();  // instancia a classe Gson
       String jsonBody = gson.toJson(user);

        // realizar o teste
        given()                                         // Dado que
                .contentType(ct)                        // o tipo de conteudo
                .log().all()                          // mostre tudo na requisição
                .body(jsonBody)                       // corpo da requisição
        .when()
                .post(uriUser) // Endpoint
        .then()                                      // Então
                .log().all()                        // mostra tudo no retorno
                .statusCode(200)                 // comunicação ida e volta ok, compara o codigo de fora
                .body("code", is(200))     // compara o codigo de dentro - tag code é 200
                .body("type", is("unknown")) // tag type é unknown
                .body("message", is(id))      // message é o userId
        ;
    }   // Fim Incluir CSV


}   // Fim da classe


