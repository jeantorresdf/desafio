package com.desafio.tests.principal;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import com.desafio.tests.Configuracao;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("Exemplo de Automação com Allure")
@Feature("Acesso à página sem login")
public class AcessoPagina {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Configuracao.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        new Thread();
        Thread.sleep(1000); // Definir o tempo limite conforme necessidade
        
    }

    @Test
    @Description("Teste para acessar a página sem login")
    public void acessoPagina() {
        driver.get(Configuracao.BASE_URL);

        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
