package com.demo.constants;

import lombok.Getter;

@Getter
public class FrameworkConstantsWithSingleton {

    //Singleton --> Single instance of a class
    private FrameworkConstantsWithSingleton(){}
    private static FrameworkConstantsWithSingleton INSTANCE=null;

    public static synchronized FrameworkConstantsWithSingleton getInstance(){
        if(INSTANCE==null){
            INSTANCE = new FrameworkConstantsWithSingleton();
        }
        return INSTANCE;
    }
    private final String requestJsonFilePath=System.getProperty("user.dir") +
            "/src/test/resources/jsons/";

    private final String responseJsonFilePath=System.getProperty("user.dir") +
            "/output/";

    private final String propertyFilePath = System.getProperty("user.dir") +
            "/src/test/resources/config.properties";

    private final String schemaFilePath = System.getProperty("user.dir")
            +"/src/test/resources/jsons/schema.json";
}
