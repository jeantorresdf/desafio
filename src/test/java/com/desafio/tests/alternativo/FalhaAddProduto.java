package com.desafio.tests.alternativo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import com.desafio.tests.Configuracao;

public class FalhaAddProduto {

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
    @Description("Teste para adicionar um produto indisponível ao carrinho")
    @Epic("Funcionalidade de Compra em um E-commerce")
    @Feature("Adicionar Produto ao Carrinho")
    public void falhaAddProduto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        
        //Realizar login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Selecionar o produto e adicioná-lo ao carrinho
        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
        Thread.sleep(1000); // Espera para carregar a página, substituir por waits adequados
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
         
    }


    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

