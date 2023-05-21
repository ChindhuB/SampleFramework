package services;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.Method;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseService {

    protected abstract RequestSpecification requestSpec();

    protected abstract ResponseSpecification responseSpec();

    protected ExtractableResponse request(Method method, String url, Map<String, ?> header) {
        return requestSpec().given().headers(header).request(method, url).then().spec(responseSpec()).extract();
    }

    protected ExtractableResponse request(Method method, Map<String, ?> params, String url, Map<String, ?> header) {

        return requestSpec().given().headers(header).params(params).request(method, url).then().spec(responseSpec()).extract();
    }

    protected ExtractableResponse request(Method method, Object model, String url, Map<String, ?> header) {
        ExtractableResponse r = requestSpec().given().headers(header).body(model).request(method, url).then().extract();
        System.out.println(r.body().asString());
        return r;
    }

    protected Map<String, String> baseheader(String uri) {
        Map<String, String> baseheader = new HashMap<String, String>();
        baseheader.put("Accept", "*/*");
        baseheader.put("Connection", "keep-alive");
        baseheader.put("Content-Type", "application/json");
        baseheader.put("Host", "auth.lambdatest.com");
        return baseheader;

    }

}
