package com.demo.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static ExtentTest getTestThread(){
        return exTest.get();
    }

    public static void setExtent(ExtentTest test){
        exTest.set(test);
    }

}
