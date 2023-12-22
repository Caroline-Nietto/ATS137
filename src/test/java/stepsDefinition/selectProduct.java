package stepsDefinition;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class selectProduct {

    static WebDriver driver;

    @BeforeAll
    public static void before_all(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
    }


    @AfterAll
    public static void after_all(){
        driver.quit();
    }


    @Given("I access SauceDemo store")
    public void i_access_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");
    }

    @When("I filled a user {string} and password {string}")
    public void i_filled_a_user_and_password(String user, String password) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click in Login")
    public void i_click_in_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("show page's title {string}")
    @Then("I verify the page's title {string}")
    public void show_page_s_title(String pageTitle) {
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), pageTitle);
    }

    @And("show cart's link")
    public void show_cart_s_link() {
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
    }

    @When("I click in product {string}")
    public void i_click_in_product(String productId) {
        driver.findElement(By.id("item_" + productId + "_title_link")).click();
    }

    @Then("I verify the product title {string}")
    public void i_verify_the_product_title(String productTitle) {
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(), productTitle);
    }

    @And("I verify the product price {string}")
    public void i_verify_the_product_price(String productPrice) {
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(), productPrice);
    }

    @When("I click in Add to Cart")
    public void i_click_in_add_to_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("I click in Cart icon")
    public void i_click_in_cart_icon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("I verify the quantity is {string}")
    public void i_verify_the_quantity_is(String quantity) {
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), quantity);
    }

}
