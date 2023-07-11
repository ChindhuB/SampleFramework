package services;

import constant.api.auth.AuthEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.api.Login;

import org.apache.http.HttpStatus;

import java.util.Map;

public class AuthService extends BaseService {
    @Override
    protected RequestSpecification requestSpec() {
        return RestAssured.given().baseUri(AuthEndpoints.BASE_URI.getUrl())
                .relaxedHTTPSValidation().contentType(ContentType.JSON)
                .accept("application/json");
    }

    @Override
    protected ResponseSpecification responseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_MOVED_TEMPORARILY);
    }

    public Login login(String email, String password) {
        return Login.builder().email(email).password(password).build();
    }

    public ExtractableResponse Authorize(String email, String pswd) {
        Map<String, String> header = baseheader(String.valueOf(AuthEndpoints.BASE_URI.getUrl()));
        Login log = login(email, pswd);
        return request(Method.POST, log, AuthEndpoints.BASE_URI.getUrl() + AuthEndpoints.LOGIN.getUrl(), header);
    }
    public Response AuthorizeRaw(String email, String pswd) {
        Map<String, String> header = baseheader(String.valueOf(AuthEndpoints.BASE_URI.getUrl()));
        Login log = login(email, pswd);
        return requestSpec().given().headers(header).body(log).request(Method.POST, AuthEndpoints.BASE_URI.getUrl() + AuthEndpoints.LOGIN.getUrl());
    }

    public String getToken(String email, String pswd) {
        return Authorize(email, pswd).cookie("accessToken");
    }
}
