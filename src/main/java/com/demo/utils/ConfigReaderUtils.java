package com.demo.utils;

import com.demo.constants.FrameworkConstantsWithSingleton;
import com.demo.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ConfigReaderUtils {

    private ConfigReaderUtils(){}

    //Read the content from property file & store it in hashmap
    //Read the content from property file only once & store it in some java colletions
    private static Properties properties = new Properties();
    private static Map<String ,String > map = new HashMap<>();

//    public static void readAndStorePropertiesFileData(){

    static { // put it static because static blocks are executed first & we need to load this data
        try(FileInputStream inputStream = new FileInputStream(FrameworkConstantsWithSingleton.getInstance().getPropertyFilePath())) { // This is try with resources
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0); // We will exit if it has not been able to load the config file. There is no point in running this hence exit
        }
        properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));
    }

    public static String getValue(PropertiesType key) {
        return map.get(key.name().toLowerCase());
    }
}
