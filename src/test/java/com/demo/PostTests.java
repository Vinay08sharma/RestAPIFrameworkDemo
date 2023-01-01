package com.demo;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.annotation.FrameworkAnnotation;
import com.demo.constants.FrameworkConstantsWithSingleton;
import com.demo.models.Posts;
import com.demo.reports.ExtentLogger;
import com.demo.reports.ExtentManager;
import com.demo.requestBuilders.RequestBuilders;
import com.demo.utils.FileUtils;
import com.demo.utils.RandomUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import static com.demo.utils.RandomUtils.*;

public class PostTests {

    @Test(description = "Post call on Posts data")
    @FrameworkAnnotation(author = {"Vinay"}, category = {"Smoke","PostTest"})
    public void PostPostData() {
        // Create post in db using post call
        // Construct using pojo n lombok
        Posts post1 = Posts
                    .builder()
                    .setId(getId())
                    .setFirstname(getFirstName())
                    .setLastname(getLastName())
                    .build();

        Response postResponse = RequestBuilders
                .buildRequestForPostCalls(post1)
                .post("/posts");

        ExtentLogger.logResponse(postResponse.asPrettyString());

        Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(201);
    }

    @Test(description = "Post call with External data file")
    @FrameworkAnnotation(author = {"Vinay", "Ravi"}, category = {"Smoke","PostTest"})
    public void PostPostDataWithExternalFile(Method method) {
        // Using singleton pattern
        String resource = FileUtils.readJsonAndGetAsString(FrameworkConstantsWithSingleton.getInstance()
                        .getRequestJsonFilePath()
                +"request.json")
                .replace("fname", RandomUtils.getFirstName())
                        .replace("number", String.valueOf(RandomUtils.getId()));
        Response response = RequestBuilders.buildRequestForPostCalls(resource)
                .post("/posts");

        // Storing the response in external file
        FileUtils.storeStringAsJsonFile(FrameworkConstantsWithSingleton
                .getInstance()
                        .getResponseJsonFilePath()
                        +method.getName()+".json", response);

        ExtentLogger.logResponse(response.asPrettyString());

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Test(description = "Post call with JsonSchema Validation")
    @FrameworkAnnotation(author = {"Vinay", "Sachin"}, category = {"Smoke","GetTest","SchemaValidation"})
    public void postCallWithJsonSchemaValidation(){
            // Using singleton pattern
            String resource = FileUtils.readJsonAndGetAsString(FrameworkConstantsWithSingleton.getInstance()
                            .getRequestJsonFilePath()
                            +"request.json")
                    .replace("fname", RandomUtils.getFirstName())
                    .replace("number", String.valueOf(RandomUtils.getId()));
            Response response = RequestBuilders.buildRequestForPostCalls(resource)
                    .post("/posts");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(
                new File(FrameworkConstantsWithSingleton.getInstance().getSchemaFilePath())));

        ExtentLogger.logResponse(response.asPrettyString());
    }
}
