import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddControllerTest {
    int a;
    int b;
    int c = a+b;
    @Test
    public void testAddNumbers() {
        String requestBody = "{\n" +
                "  \"number1\": "+a+",\n" +
                "  \"number2\": "+b+"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(200)
                .body(equalTo("The result is: "+c));
    }
    @Test
    public void testAddTwoNulls() {
        String requestBody = "{\n" +
                "  \"number1\": "+null+",\n" +
                "  \"number2\": "+null+"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(200)
                .body(equalTo("The result is: "+0));
    }
    @Test
    public void testInvalidBody() {


        /*String requestBody = "{\n" +
                "  \"number1\": 10,\n" +
                "  \"number2\": 20\n" +
                "}";*/
        String requestBody = "";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(400);
    }



}
