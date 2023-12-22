package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class seleniumSimples {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testarSelectBackdrop(){

        // Abrir página inicial
        driver.get("https://www.saucedemo.com");

        // Fazer login
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verifica se mudou para a pagina de produtos
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), "Products");
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());

        // Clica no produto para ver os detalhes do produto
        driver.findElement(By.id("item_4_title_link")).click();

        // Verifica o nome e o preço do produto
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(),
                "Sauce Labs Backpack");

        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(),
                "$29.99");

        // Clica no botão Adicionar
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Clica no Carrinho
        driver.findElement(By.id("shopping_cart_container")).click();

        // Verifica o Titulo da Pagina, nome do produto, quantidade e preço
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), "Your Cart");
        assertEquals(driver.findElement(By.id("item_4_title_link")).getText(),
                "Sauce Labs Backpack");
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), "1");
        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(),
                "$29.99");
    }


}
