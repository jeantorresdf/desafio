package com.desafio.tests.alternativo;

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

public class FalhaDEscAposCompra {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Teste para selecionar um produto e adicionar ao carrinho")
    @Epic("Funcionalidades do E-commerce")
    @Feature("Adicionar Produto ao Carrinho")
    public void falhaDEscAposCompra() throws InterruptedException {
        driver.get(Configuracao.BASE_URL);

        // Login
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SENHA);
        driver.findElement(By.id("login-button")).click();

        // Aguardar o login
        Thread.sleep(2000);

    //Selecionar o produto
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        //adicionar ao carrinho
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Aguardar o produto ser adicionado
        Thread.sleep(2000);

       // Simula a desconexão ou logout
        driver.get(Configuracao.BASE_URL);

        // Aguardar a finalização do logout
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

