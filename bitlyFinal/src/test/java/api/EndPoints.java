package api;

import io.restassured.RestAssured;
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
        request.header("Accept", "application/json");
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
//        return new RestResponse(Group.class, response);
        return response;
    }

    public Response getGroupAllGroups() {
        String groups = RequestPaths.allGroups();
        Response response = request.get(groups);
        response.then().log().all().extract().response();
//        return new RestResponse(Group.class, response);
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
        request.contentType("application/json");
        Response response = request.body(createBitLinkRequest).post(RequestPaths.bitlinks());
        response.then().log().all().extract().response();
        return response;
    }


}
