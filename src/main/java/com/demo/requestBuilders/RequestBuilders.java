package com.demo.requestBuilders;

import com.demo.enums.PropertiesType;
import com.demo.models.Posts;
import com.demo.utils.ConfigReaderUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public final class RequestBuilders {

    //private since we dont want people to extend this
    private RequestBuilders(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .baseUri(ConfigReaderUtils.getValue(PropertiesType.BASEURL))
                .log()
                .all();
    }

    public static RequestSpecification buildRequestForPostCalls(Object post) {
        return given()
                .baseUri(ConfigReaderUtils.getValue(PropertiesType.BASEURL))
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(post);
    }
}
