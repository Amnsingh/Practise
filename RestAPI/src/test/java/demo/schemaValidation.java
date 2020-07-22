package demo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class schemaValidation {

    @Test
    public void testJsonSchema() {

        RestAssured.given()
            .when()
            .get("http://localhost:3000/users")
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("JsonSchemaFile.json"));

    }
}