package praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Credentials {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public static final String BASE_PATH = "/api";

    public RequestSpecification spec() {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH);
    }
}
