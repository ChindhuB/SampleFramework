package services;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import models.api.UserLogin;
import org.apache.http.HttpStatus;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

public class LoginService extends AuthService{

    public UserLogin userLoginVerify(String email, String pswd)  {

                return Authorize(email, pswd).jsonPath().getObject(".", UserLogin.class);

    }
    public boolean valuserLoginSchema(String email, String pswd){
   return  !AuthorizeRaw(email, pswd).then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("./src/main/resources/api/schemas/user_verify_schema.json")))
           .log().all().toString().isEmpty();

    }
}
