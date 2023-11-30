package com.desafio.tests.excecao;

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

public class TesteErroConexao {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Teste para simular erro de conexão após o login")
    @Epic("Funcionalidades do E-commerce")
    @Feature("Erro de Conexão")
    public void testeErroConexao() throws InterruptedException {
        driver.get(Configuracao.BASE_URL);

        // Login
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SENHA);
        driver.findElement(By.id("login-button")).click();

// Aguardar o login
     Thread.sleep(2000);


    driver.navigate().refresh();

// Aguarda a finalização da simulação de erro de conexão
        Thread.sleep(2000);
        
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

