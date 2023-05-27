package com.example.produktapi.repository;

import com.example.produktapi.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;


    @Test
    void testingOurRepository() {
        List<Product> productList = underTest.findAll();
        assertFalse(productList.isEmpty());
    }

    @Test
    void whenSearchingForAnExistingTitle_thenReturnThatProduct() {
        //given
        String title = "En dator";
        underTest.save(new Product(title,
                25000.0,
                "Elektronik",
                "bra o ha",
                "urlTillBild"));
        // when
        Optional<Product> optionalProduct = underTest.findByTitle("En dator");
        // then
        assertTrue(optionalProduct.isPresent());
        assertFalse(optionalProduct.isEmpty());
        Assertions.assertEquals(title, optionalProduct.get().getTitle());

        Assertions.assertAll(

        );

    }

    @Test //Viktors Test
    void whenSearchingForAnNonExistingTitle_thenReturnEmpty() {
        Optional<Product> optionalProduct = underTest.findByTitle("En annan dator");

        assertFalse(optionalProduct.isPresent());
        assertTrue(optionalProduct.isEmpty());
    }
    @Test //Mathildas Test
    void whenSearchingForNonExistingTitle_thenReturnEmptyOptional() {
        //given
        String title = "En titel som absolut inte finns";

        //when
        Optional<Product> optionalProduct = underTest.findByTitle(title);

        //then
        assertFalse(optionalProduct.isPresent());
        assertTrue(optionalProduct.isEmpty()); //AssertTrue den är väll inte tom?
    }
}