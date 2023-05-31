package com.example.produktapi.Selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.*;

public class SeleniumTests {

    @Test
    @Disabled
    public void checkTitleOfWebSite(){

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(option);


        driver.get("https://java22.netlify.app/");

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        assertEquals("Webbutik", driver.getTitle(), "Titeln stämmer inte med förväntat!"); // Vi kollar om titeln på hemsidan är "Webbutik"
        // Vid fel titel skrivs "message" ut

        driver.quit();
    }
    @Test
    @Disabled
    public void shouldBeTwentyProducts(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);


        driver.get("https://java22.netlify.app/");

                WebElement productsShowing = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.className("productItem")));

        List<WebElement> products = driver.findElements(By.className("productItem"));
        assertTrue(productsShowing.isDisplayed(), "Produkterna vissas inte!"); // Vi kollar att produkterna visas på hemsidan
        assertEquals(20, products.size(), "Antalet produkter stämmer inte!"); // Vi kollar så att vi har 20 produkter på hemsidan

        driver.quit();
    }

    @Test
    @Disabled
    public void checkThatOneProductHasAPrice(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);


        driver.get("https://java22.netlify.app/");



                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        String productOne = driver.findElement(By.xpath("//*[@id=\"productsContainer\"]/div/div[1]/div/div/p")).getText(); //Hämtar xpathen av produkten
        String findPriceForProductOne = "109.95";
        boolean validatePriceForProductOne = productOne.contains(findPriceForProductOne);

        assertTrue(validatePriceForProductOne, "Priset stämmer inte!");

        driver.quit();
    }
    @Test
    @Disabled
    public void checkThatAnotherProductHasAPrice(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);


        driver.get("https://java22.netlify.app/");



                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        String productTwo = driver.findElement(By.xpath("//*[@id=\"productsContainer\"]/div/div[2]/div/div/p")).getText();
        String findPriceForProductTwo = "22.3";
        boolean validatePriceForProductTwo = productTwo.contains(findPriceForProductTwo);

        assertTrue(validatePriceForProductTwo, "Priset stämmer inte!");
        driver.quit();
    }
    @Test
    @Disabled
    public void checkThatYetAnotherProductHasAPrice(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);


        driver.get("https://java22.netlify.app/");



                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        String productThree = driver.findElement(By.xpath("//*[@id=\"productsContainer\"]/div/div[3]/div/div/p")).getText();
        String findPriceForProductThree = "55.99";
        boolean validatePriceForProductThree = productThree.contains(findPriceForProductThree);

        assertTrue(validatePriceForProductThree, "Priset stämmer inte!");

        driver.quit();
    }
}
