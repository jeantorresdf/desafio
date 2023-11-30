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

public class LoginPagina {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("Teste para fazer login no SauceDemo e verificar a presença do elemento 'Products'")
    @Epic("Exemplo de Automação com Allure")
    @Feature("Acesso à página e login")
    public void fazerLoginTest() throws InterruptedException {
        driver.get(Configuracao.BASE_URL);

        // Preencher o login e senha
        driver.findElement(By.id("user-name")).sendKeys(Configuracao.USUARIO);
        driver.findElement(By.id("password")).sendKeys(Configuracao.SENHA);

        // Clicar no botão de login
        driver.findElement(By.id("login-button")).click();

        // Tempo de espera para carregar a página após o login
        Thread.sleep(2000); // 2 segundos

        // Verificar se o elemento "Products" está presente
        WebElement productsElement = driver.findElement(By.className("title"));
        if (productsElement.isDisplayed()) {
            System.out.println("Elemento 'Products' encontrado.");
        } else {
            System.out.println("Elemento 'Products' não encontrado.");
        }
    }

    @AfterTest
    public void tearDown() {
        // Fechar o navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
