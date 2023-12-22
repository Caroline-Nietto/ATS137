package apiTest;


import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteBookStore {

    // Uso Comum
    Gson gson = new Gson();
    static String ct = "application/json";

    static String jsonBody;

    // EndPoints
    static String uriAccount = "https://bookstore.toolsqa.com/Account/v1/";


    // Dados da Conta / Account

    static String userName = "nietto7";
    static String password = "Cn*261015";

    static String userId;
    static String token;

    @Test
    @Order(1)
    public void testeCriarUsuario(){

        Account account = new Account();
        account.userName = userName;
        account.password = password;
        jsonBody = gson.toJson(account);


        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "User")
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(userName))
                .extract()
        ;

        userId = resp.jsonPath().getString("userID");
        System.out.println("userId: " + userId);

    }

    @Test
    @Order(2)
    public void testeTokenUser(){

        Response resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriAccount + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
                .extract()
        ;

        token = resp.jsonPath().getString("token");
        System.out.println("token: " + token);
    }

    @Test
    @Order(66)
    public void testeExcluirUsuario(){
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uriAccount + "user/" + userId)
        .then()
                .statusCode(204)
        ;
    }

}
