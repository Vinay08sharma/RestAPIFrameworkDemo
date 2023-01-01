package com.demo.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtils {

    private FileUtils(){}

    @SneakyThrows
    public static String readJsonAndGetAsString(String filepath){
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    @SneakyThrows
    public static void storeStringAsJsonFile(String filepath, Response response) {
        Files.write(Paths.get(filepath),response.asByteArray());
    }


}
