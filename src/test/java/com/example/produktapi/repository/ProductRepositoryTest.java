package com.example.produktapi.repository;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;


    @Test
    void whenSearchingForExistingTitle_thenReceiveThatProduct() {
        //given (Här skapar vi en produkt som vi sedan hämtar titeln ifrån!)
        Product product = new Product("Dator", 20000.0, "Elektronik", "Används för att koda i Java", "urlSträng");
        underTest.save(product);

        //when
        Optional<Product> result = underTest.findByTitle(product.getTitle()); // Här hämtar vi titeln från "product" vi precis skapade.

        //then
        Assertions.assertAll(
                ()-> assertTrue(result.isPresent()), //Vi kollar så att det finns något i "result"
                ()-> assertEquals(result.get().getTitle(), "Dator") //Här hämtar vi och kollar titeln i "result" och kollar om den är samma som "Dator"
        );
    }

    @Test
    void WhenSearchingForNonExistingTitle_thenReturnTrue() {
        //Denna gång skapar vi inget eftersom vi vill söka efter något som inte existerar.

        //when
        Optional<Product> result = underTest.findByTitle("Denna titel exsisterar inte!"); //Här hämtar vi titeln "Denna titel exsisterar inte!" och de finns ingen -
        // variabel med denna titel.

        //then
        Assertions.assertAll(
                ()-> assertFalse(result.isPresent()), //Inget kommer vara present
                ()-> assertTrue(result.isEmpty()), // Den kommer vara empty
                ()-> assertThrows(NoSuchElementException.class, ()-> result.get())
        );
    }

    @Test
    void findByCategory_checkIfListProductIsEmptyThenReturnFalse_checkIfCategoryIsCorrectThenReturnTrue() {
        // given
        String category = "Elektronik"; // Vi skapar en string "category" som har värdet "Elektronik"
        Product product = new Product("En dator", 250000.0, category, "bra at ha till java", "urlTillBild");
        underTest.save(product); // Vi sparar våran produkt

        // when
        List<Product> listProduct = underTest.findByCategory("Elektronik"); // Vi använder oss av "findByCategory" för att leta efter "Elektronik"

        // then
        assertFalse(listProduct.isEmpty()); //Den är inte tom
        assertEquals(category, listProduct.get(0).getCategory()); // Vi jämför våran String med listproduct
    }

    @Test
    void findByCategory_checkIfListProductIsEmpty_thenReturnTrue() {
        // given
        underTest.deleteAll(); // Vi tar bort allt från vårat produkt repository

        // when
        List<Product> listProduct = underTest.findByCategory("Elektronik"); // Vi letar efter kategorin "Elektronik"

        // then
        assertTrue(listProduct.isEmpty()); // Den kommer vara tom eftersom vi tidigare tog bort allt
    }
    @Test
    void findAllCategories_thenCheckIfListProductIsEmpty_thenCheckSizeOfListProduct_thenReturnTrue(){
        // when
        List<String> listProduct = underTest.findAllCategories();

        // then
        assertFalse(listProduct.isEmpty());
        assertEquals(listProduct.size(), 4); //Hör kollar vi hur stor listProduct är och jämför detta med 4. Vi kommer få true då listproduct är 4.
    }

    @Test
    void givenAListWithSameContentAsRepository_thenSearchForAllCategories_thenCheckListSize_thenCompareToListProduct(){
        List <String> categories = new ArrayList<>(Arrays.asList("electronics", "jewelery", "men's clothing", "women's clothing")); // Fail electronic
        categories.stream().distinct().collect(Collectors.toList());

        List<String> listProduct = underTest.findAllCategories();

        assertTrue(listProduct.size() == 4); // Kollar så listans size är 4.
        assertEquals(categories, listProduct); // Jämför Listorna för att se om dem är likadana.
    }
}