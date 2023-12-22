package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Base{
    // Construtor
    public ReservePage(WebDriver driver) {
        super(driver);
    }

    // Mapeamento dos Elementos
    // Apenas a fase que diz a origem e o destino
    public By byCabecalhoListaDeVoos = By.cssSelector("div.container h3");

    // Ação
    public String LerCabecalhoListaDeVoos(){
        return driver.findElement(byCabecalhoListaDeVoos).getText();
    }

    // ler o titulo da guia Reserve
    public String LerTituloGuia(){
        return driver.getTitle();
    }
}
