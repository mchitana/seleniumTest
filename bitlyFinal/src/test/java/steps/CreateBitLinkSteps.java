package steps;

import api.EndPoints;
import api.RestResponse;
import entities.BitLinks;
import entities.ErrorsDetails;
import entities.Group;
import entities.Link;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import requests.CreateBitLinkRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class CreateBitLinkSteps {
    private static final String groupId = "Bk66h3Iprvs";
    private static String domain = "bit.ly";
    private String long_url;
    private EndPoints endPoints;

    public CreateBitLinkSteps(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    @Given("^user request links sorted by (clicks|unknown?) for the past (.*?) (month|day|hour|minute|year)(?:s)?$")
    public void sortedGroupsByClicks(String sortType, String duration, String timeRange) {
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("unit", timeRange);
        queryParameters.put("units", duration);
        endPoints.getSortedLinksByClicks(groupId, sortType, queryParameters);
    }

    @And("^user makes a request to create a bitlink$")
    public void aRequestToCreateABitlink() {
        CreateBitLinkRequest createBitLinkRequest = CreateBitLinkRequest.builder()
                .group_guid(groupId)
                .title("New Title")
                .domain(domain)
                .long_url(long_url)
                .build();
        endPoints.createBitLink(createBitLinkRequest);
    }


    @And("^user makes a request to create a bitlink with a malformed payload$")
    public void malformedJson() {
        String s = "{\n" +
                "   \"domain\": \"bit.ly\",\n" +
                "   \"title\": \"New Title\",,\n" +
                "   \"group_guid\": \"Bk66h3Iprvs\",\n" +
                "   \"tags\": null,\n" +
                "   \"deeplinks\": null,\n" +
                "   \"long_url\": \"https://www.example.com/1591942391908\"\n" +
                "}";
        endPoints.createBitLink(s);
    }

    @Given("^a(?:n)? (empty|valid|encoded) long_url$")
    public void long_url(String type) throws UnsupportedEncodingException {
        String url = "https://www.example.com/" + System.currentTimeMillis();
        switch (type) {
            case "valid":
                long_url = url;
                break;
            case "empty":
                long_url = "";
                break;
            case "encoded":
                long_url = URLEncoder.encode(url, "UTF-8");
                break;
        }
    }

    @Then("^the bitlink is created$")
    public void bitLinkCreated() {
        RestResponse<Link> createBitlinkResponse = new RestResponse<>(Link.class, endPoints.getResponse());
        Assert.assertEquals(201, createBitlinkResponse.getStatusCode());
        Assert.assertNotNull(createBitlinkResponse.getBody());
        Assert.assertNotNull(createBitlinkResponse.getBody().getId());
        Assert.assertNotNull(createBitlinkResponse.getBody().getLink());
        Assert.assertEquals(long_url, createBitlinkResponse.getBody().getLong_url());
    }

    @Then("^the bitlink is not created$")
    public void bitLinkNotCreated() {
        RestResponse<Link> createBitlinkResponse = new RestResponse<>(Link.class, endPoints.getResponse());
        Assert.assertEquals(400, createBitlinkResponse.getStatusCode());
    }

    @Given("^an unknown domain name$")
    public void anUnknownDomainName() {
        domain = "unknown";
    }

    @Then("^a list of sorted links are returned$")
    public void aListOfSortedLinksAreReturned() {
        RestResponse<BitLinks> sortedBitLinksResponse = new RestResponse(BitLinks.class, endPoints.getResponse());
        Assert.assertEquals(200, sortedBitLinksResponse.getStatusCode());
        Assert.assertTrue(sortedBitLinksResponse.getBody().getSorted_links().size() > 0);
    }

    @Then("^an empty list of links is returned$")
    public void anEmptyListIsReturned() {
        RestResponse<BitLinks> sortedBitLinksResponse = new RestResponse(BitLinks.class, endPoints.getResponse());
        Assert.assertEquals(200, sortedBitLinksResponse.getStatusCode());
        Assert.assertTrue(sortedBitLinksResponse.getBody().getLinks().isEmpty());
    }

    @Then("^the http response code is (\\d+) with an error message (.*?)$")
    public void theRsponseIsABadRequestWithErrorMessage(int httpStatusCode, String errorMessage) {
        RestResponse<ErrorsDetails> errorRestResponse = new RestResponse(ErrorsDetails.class, endPoints.getResponse());
        Assert.assertEquals(httpStatusCode, errorRestResponse.getStatusCode());
        Assert.assertNotNull(errorRestResponse.getBody());
        Assert.assertEquals(errorMessage, errorRestResponse.getBody().getMessage());
    }
}
