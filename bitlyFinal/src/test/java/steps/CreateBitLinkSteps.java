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
    public String validGroupId;
    private RestResponse<Group> groupResponse;
    private RestResponse<BitLinks> sortedBitLinksResponse;
//    private RestResponse<Link> createBitlinkResponse;
    private static final String groupId = "Bk66h3Iprvs";
    private static final String defaultDomain = "bit.ly";
    private String long_url;
    private EndPoints endPoints;

    public CreateBitLinkSteps(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    @Given("^user request links sorted by (clicks|unknown?) for the past (month|day|hour|minute)$")
    public void sortedGroupsByClicks(String sortType, String duration) {
        HashMap<String, String> queryParameters = new HashMap<>();
        queryParameters.put("unit", duration);
        queryParameters.put("units", "1");
        endPoints.getSortedLinksByClicks(groupId, sortType, queryParameters);
    }

    @And("^user makes a request to create a bitlink$")
    public void aRequestToCreateABitlink() {
        CreateBitLinkRequest createBitLinkRequest = CreateBitLinkRequest.builder()
                .group_guid(groupId)
                .title("New Title")
                .domain(defaultDomain)
                .long_url(long_url)
                .build();
        endPoints.createBitLink(createBitLinkRequest);
    }

    @Given("^a(?:n)? (empty|valid) long_url$")
    public void long_url(String type) throws UnsupportedEncodingException {
        String encodedUrl = "https://www.example.com/" + System.currentTimeMillis();
        URLEncoder.encode(encodedUrl, "UTF-8");
        long_url = type.equals("valid") ? encodedUrl : "";
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
        // createBitlinkResponse.
    }

    @Given("^an unknown domain name$")
    public void anUnknownDomainName() {

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

    @Then("^the http response code is (\\d+) with an error message$")
    public void theRsponseIsABadRequestWithErrorMessage(int httpStatusCode) {
        RestResponse<ErrorsDetails> errorRestResponse = new RestResponse(ErrorsDetails.class, endPoints.getResponse());
        Assert.assertEquals(httpStatusCode, errorRestResponse.getStatusCode());
        Assert.assertNotNull(errorRestResponse.getBody());
    }
}
