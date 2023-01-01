package com.demo;

import com.demo.annotation.FrameworkAnnotation;
import com.demo.reports.ExtentLogger;
import com.demo.requestBuilders.RequestBuilders;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetTests {

    @Test(description = "Get call to get all the posts")
    @FrameworkAnnotation(author = {"Vinay"}, category = {"Smoke","GetTest"})
    public void getPostsDetails() {
        Response response = RequestBuilders
                .buildRequestForGetCalls()// We can take this baseUri from config.properties file or class
                .get("/posts");
        assertThat(response.getStatusCode())
                .isEqualTo(200);

        ExtentLogger.logResponse(response.asPrettyString());

        //Asserting the number of posts added in the db
        assertThat(response.jsonPath().getList("$").size())
                .isGreaterThan(10)
                .as("Validating the size of posts added in the DB")
                .isPositive();
    }

    @Test(dataProvider = "getData", description = "Get call for specific post")
    @FrameworkAnnotation(author = {"Vinay"}, category = {"Smoke","GetTest"})
    public void getSinglePostsDetails(Integer id, String expected) {
        Response response = RequestBuilders.buildRequestForGetCalls()
                .pathParam("id",id)
                .get("/posts/{id}");

//        ExtentReport.getTestThread().pass(response.prettyPrint());

        ExtentLogger.logResponse(response.asPrettyString());
        assertThat(response.getStatusCode())
                .isEqualTo(200);

        assertThat(response.jsonPath().getString("title"))
                .isEqualTo(expected)
                .as("Validating the lastname of 1st employee");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {1,"json-server" },
                {4, "asdasdas"},
                {51, "sadasd"}
        };
    }

}
