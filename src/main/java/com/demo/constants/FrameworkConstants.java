package com.demo.constants;

import lombok.Getter;

public class FrameworkConstants {


    //Since it static variable we need to add getter in the field level
    @Getter
    private static final String requestJsonFilePath=System.getProperty("user.dir") +
            "/src/test/resources/jsons/";

    @Getter
    private static final String responseJsonFilePath=System.getProperty("user.dir") +
            "/output/";
}
