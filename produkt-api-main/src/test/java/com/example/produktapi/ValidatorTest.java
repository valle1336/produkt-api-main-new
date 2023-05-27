package com.example.produktapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
public class ValidatorTest {

    @Test
    void givenValidEmailAddress_whenValidate_thenReturnTrue() {

    }

    /*
    public static boolean isMailValid(String email){
        int indexOfAt = email.lastIndexOf("@");
        if (!Pattern.matches("[a-zA-Z0-9]", email))

            return true;
    }



    //

    @Test
    void givenOnlyLetters_whenValidatingPhoneNumber_thenReturnFalse() {
        Assertions.assertTrue(isMailValid("name@domain.se"));
    }

    @Test
    void s(){
        Assertions.assertFalse(isMailValid("domain.se"));
    }

     */

}
