package com.demo.utils;

public final class RandomUtils {

    private RandomUtils(){}

    public static int getId(){
        return FakerUtils.getNumber(100,1000);
    }

    public static String getFirstName(){
        return FakerUtils.getRandomFirstName().trim();
    }

    public static String getLastName(){
        return FakerUtils.getRandomLastName().trim();
    }

}
