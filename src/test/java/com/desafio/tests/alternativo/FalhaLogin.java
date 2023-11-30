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

public class FalhaLogin {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    @Description("Teste para fazer login com senha incorreta")
    public void falhaLogin() {
        driver.get(Configuracao.BASE_URL);

//login com senha incorreta
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SenhaErrada);
        driver.findElement(By.id("login-button")).click();

    // Verificação se a mensagem esperada é exibida
        boolean isErrorMessageDisplayed = driver.findElement(By.cssSelector(".error-message-container.error"))
                .getText().contains("Epic sadface: Username and password do not match any user in this service");
        assert isErrorMessageDisplayed : "Mensagem de erro não encontrada!";
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}


