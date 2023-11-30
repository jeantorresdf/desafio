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


public class AcessarCarrinho {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    @Description("Adicionar produto ao carrinho")
    public void adicionarAoCarrinho() {
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

        // Selecionar o produto
        WebElement product = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div"));
        product.click();

        //Esperar para carregar os detalhes do produto
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Adicionar o produto ao carrinho
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();

        // Esperar para garantir que o produto foi adicionado ao carrinho
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Acessar o carrinho
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a"));
        shoppingCart.click();

        //esperar para carregar a página do carrinho
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Remover o produto do carrinho - //*[@id="remove-sauce-labs-backpack"]
        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
        removeButton.click();

    //Esperar para garantir que o produto foi removido do carrinho
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

