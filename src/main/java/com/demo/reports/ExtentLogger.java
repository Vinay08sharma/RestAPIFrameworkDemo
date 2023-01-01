package com.demo.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

    private ExtentLogger() {}

    public static void pass(String message) {
        ExtentManager.getTestThread().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getTestThread().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void info(String message) {
        ExtentManager.getTestThread().info(message);
    }

    public static void logResponse(String message) {
        ExtentManager.getTestThread().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }
}
