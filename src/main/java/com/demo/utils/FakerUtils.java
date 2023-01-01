package com.demo.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker = new Faker();
     static int getNumber(int startVal, int endVal){
        return faker.number().numberBetween(startVal,endVal);
    }

     static String getRandomFirstName() {
        return faker.name().firstName();
    }

     static String getRandomLastName() {
        return faker.name().lastName();
    }

}
