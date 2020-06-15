package api;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requests.CreateBitLinkRequest;

import java.util.HashMap;

public class EndPoints {
    private final String baseUrl = "https://api-ssl.bitly.com";
    private final RequestSpecification request;

    private Response response;

    public EndPoints() {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.urlEncodingEnabled(false);
        request.accept( "application/json");
        request.log().all();
    }

    public Response getResponse() {
        return response;
    }

    public void authenticateUser(String accessToken) {
        request.header("Authorization", "Bearer " + accessToken);
    }


    public Response getGroupById(String groupId) {
        String groups = RequestPaths.groups(groupId);
        response = request.get(groups);
        response.then().log().all().extract().response();
        return response;
    }

    public Response getSortedLinksByClicks(String groupId, String sortType, HashMap<String, String> queryParameters) {
        String groups = RequestPaths.sortedLinksByClicks(groupId, sortType);
        request.queryParams(queryParameters);
        response = request.get(groups);
        response.then().log().all().extract().response();
        return response;
    }

    public Response createBitLink(CreateBitLinkRequest createBitLinkRequest) {
        EncoderConfig encoderConfig = EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
        request.contentType(ContentType.JSON).config(RestAssuredConfig.config().encoderConfig(encoderConfig));
        response = request.body(createBitLinkRequest).post(RequestPaths.bitlinks());
        response.then().log().all().extract().response();
        return response;
    }

    public Response createBitLink(String createBitLinkRequestString) {
        EncoderConfig encoderConfig = EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
        request.contentType(ContentType.JSON).config(RestAssuredConfig.config().encoderConfig(encoderConfig));
        response = request.body(createBitLinkRequestString).post(RequestPaths.bitlinks());
        response.then().log().all().extract().response();
        return response;
    }


}
