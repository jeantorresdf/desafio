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

import com.desafio.tests.Configuracao;//Carrega dados da class Configuracao.java para logar

public class TesteTempoLimiteSessao {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    @Description("Teste para simular tempo limite de sessão após o login")
    @Epic("Funcionalidades do E-commerce")
    @Feature("Tempo Limite de Sessão")
    public void testeTempoLimiteSessao() throws InterruptedException {
        driver.get(Configuracao.BASE_URL);

        //Login
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SENHA);
        driver.findElement(By.id("login-button")).click();

        // Aguardar o login ser concluído
        Thread.sleep(2000);

     // Simula um tempo limite de sessão após o login
 //exemplo que apenas atualizar a página para simular o tempo limite da sessão
        driver.navigate().refresh();

     //Aguardar a finalização da simulação do tempo limite de sessão
        Thread.sleep(2000);

    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
