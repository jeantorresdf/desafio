package com.desafio.tests.principal;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.desafio.tests.Configuracao;

public class FinalizarCompra {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    @Description("Login na página")
    public void login() {
        driver.get(Configuracao.BASE_URL);
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SENHA);
        driver.findElement(By.id("login-button")).click();
        // Espera para garantir que a página seja carregada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    @Description("Selecionar produto e adicionar ao carrinho")
    public void selectProductAndAddToCart() {
        // Seleciona o produto Sauce Labs Backpack
        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
        // Adiciona o produto ao carrinho
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        // Espera para garantir que o produto foi adicionado ao carrinho
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    @Description("Finalizar compra")
    public void checkout() {
        // Acessa o carrinho de compras
        driver.findElement(By.id("shopping_cart_container")).click();
        // Inicia o checkout
        driver.findElement(By.id("checkout")).click();
        // Informa os detalhes para finalizar a compra (poderiam ser mais passos aqui)
        driver.findElement(By.id("first-name")).sendKeys("Nome");
        driver.findElement(By.id("last-name")).sendKeys("Sobrenome");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        // Confirma a compra
        driver.findElement(By.id("finish")).click();
        // Espera para garantir que a compra foi finalizada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
