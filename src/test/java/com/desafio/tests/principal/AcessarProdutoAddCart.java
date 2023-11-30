package com.desafio.tests.principal;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.desafio.tests.Configuracao;

public class AcessarProdutoAddCart {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new Thread();
        Thread.sleep(1000);
    }

    @Test
    @Description("Adicionar produto ao carrinho")
    public void acessarProdutoAddCart() {
        driver.get(Configuracao.BASE_URL);

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(Configuracao.USUARIO);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(Configuracao.SENHA);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //esperar para carregar a página 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    //sSelecionar o produto
        WebElement product = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div"));
        product.click();

        //espera para carregar o detalhar do produto
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Adicionar o produto ao carrinho
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
