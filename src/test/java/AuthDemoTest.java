import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthDemoTest {
    
    @Test
    public void basicAuthTest(){
        Response response = given()
                .config(RestAssuredConfig.config()
                        .logConfig(LogConfig.logConfig()
                                .blacklistHeader("Authorization")))
                .header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
                .log().all()
                .get("https://postman-echo.com/basic-auth");
        response.prettyPrint();
    }

    @Test
    public void getRepos(){
        Response response = given().header("Authorization", "")
                .queryParam("per_page", 1)
                .log()
                .all()
                .get("https://api.github.com/user/repos");

        response.prettyPrint();
    }
}
