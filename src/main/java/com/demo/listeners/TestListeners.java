package com.demo.listeners;

import com.demo.annotation.FrameworkAnnotation;
import com.demo.reports.ExtentLogger;
import com.demo.reports.ExtentManager;
import com.demo.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDown();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String description = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        ExtentReport.createTest(description);
        //We will get annotations values here
        String[] authors = result.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(FrameworkAnnotation.class)
                .author();
        ExtentReport.addAuthor(authors);

        String[] categories = result.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(FrameworkAnnotation.class)
                .category();
        ExtentReport.addCategories(categories);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() +"is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
    }
}
