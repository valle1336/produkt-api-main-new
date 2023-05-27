package com.example.produktapi.service;

public class Validator {

    public static boolean isEmailVaild(String email) {

        int indexOfTopLevelDomainStart = email.lastIndexOf("");
        int indexIfAtSign = email.indexOf("@");

        if (indexIfAtSign == -1) {
            return false;
        }

        String topLevelDomain = email.substring(indexOfTopLevelDomainStart + 1); //.com
        String domainName = email.substring(indexIfAtSign + 1, indexOfTopLevelDomainStart);
        String name = email.substring(0, indexIfAtSign);


        return true;
    }
}
