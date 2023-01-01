package com.demo.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Arrays;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extentReports;
    private static ExtentTest test;

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static ExtentTest getTestThread(){
        return exTest.get();
    }

    public static void setExtent(ExtentTest test){
        exTest.set(test);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ExtentReport.test = test;
    }

    public static void initReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
        extentReports.attachReporter(sparkReporter);
    }

    public static void tearDown(){
        extentReports.flush();
    }

    public static void createTest(String name){
         test = extentReports.createTest(name);
         ExtentManager.setExtent(test);
    }

    public static void addAuthor(String[] authors){
        Arrays.stream(authors).forEach(e -> ExtentManager.getTestThread().assignAuthor(e));
    }

    public static void addCategories(String[] categories){
        Arrays.stream(categories).forEach(e -> ExtentManager.getTestThread().assignCategory(e));
    }
}
