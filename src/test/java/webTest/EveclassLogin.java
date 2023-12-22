package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EveclassLogin {
    // Atributos

    WebDriver driver;
    WebDriverWait wait; // objeto de espera

    // Antes do Teste
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    // Depois do Teste
    @AfterEach
    public void tearDown(){
      driver.quit();
    }

    // Testes

    @Test
    public void testeLogin(){

        // Abre a pagina
        driver.get("https://testando.eveclass.com");

        // Clica no botao Entrar
        driver.findElement(By.id("support-action")).click();
        // Atualiza a pagina
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-header h1")));

        // Preencher os dados de e-mail e senha
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys(Keys.chord("niettocaroline@gmail.com"));
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("123456");

        // Clicar no botão Entrar
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        // Transição de Tela, pode precisar de um novo wait
        // Clicar nas informações de usuario para abrir o menu
        driver.findElement(By.cssSelector("div.user-avatar avatar-initials")).click();

        // Verificar se o nome está aparecendo na tela
        assertEquals("Jose Antonio Fernandes Correia", driver.findElement(By.cssSelector("p.infos-text")).getText());
    }


}
