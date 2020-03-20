package in.reqres;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test()
    public void firstTest(){
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsoneResponse= response.jsonPath();
        Assert.assertFalse(jsoneResponse.get("page").toString().isEmpty(), "page is null");
        Assert.assertFalse(jsoneResponse.get("per_page").toString().isEmpty(), "per_page is null");
        Assert.assertFalse(jsoneResponse.get("total").toString().isEmpty(), "total is null");
        Assert.assertFalse(jsoneResponse.get("total_pages").toString().isEmpty(), "total_pages is null");
        jsoneResponse.getList("data.id").forEach(x -> Assert.assertFalse(x.toString().isEmpty(),"data.id is null"));
        jsoneResponse.getList("data.email").forEach(x -> Assert.assertFalse(x.toString().isEmpty(),"data.email is null"));
        jsoneResponse.getList("data.first_name").forEach(x -> Assert.assertFalse(x.toString().isEmpty(),"data.first_name is null"));
        jsoneResponse.getList("data.last_name").forEach(x -> Assert.assertFalse(x.toString().isEmpty(),"data.last_name is null"));
        jsoneResponse.getList("data.avatar").forEach(x -> Assert.assertFalse(x.toString().isEmpty(),"data.avatar is null"));
        Assert.assertFalse(jsoneResponse.get("ad.company").toString().isEmpty(), "ad.company is null");
        Assert.assertFalse(jsoneResponse.get("ad.url").toString().isEmpty(), "ad.url is null");
        Assert.assertFalse(jsoneResponse.get("ad.text").toString().isEmpty(), "ad.text is null");
    }

    @Test()
    public void secondTest(){
        Map<String, String> data= new HashMap<>();
        data.put("name","morpheus");
        data.put("job","leader");
        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        JsonPath jsoneResponse = response.jsonPath();
        Assert.assertEquals(jsoneResponse.get("name").toString(),data.get("name"),"Name is not valid");
        Assert.assertEquals(jsoneResponse.get("job").toString(),data.get("job"),"Job is not valid");
    }
}
