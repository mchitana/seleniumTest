package steps;

import api.EndPoints;
import api.RestResponse;
import entities.Group;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GroupSteps {
    public String validGroupId;
//    private RestResponse<Group> groupResponse;
//    private RestResponse<BitLinks> sortedBitLinksResponse;
//    private RestResponse<Link> createBitlinkResponse;
    private EndPoints endPoints ;
    private String group_id = "Bk66h3Iprvs";

    public GroupSteps(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    @Given("^user requests to get groups using (?:a)? (valid|invalid) group_id$")
    public void getGroupById(String type) {
        String groupId = type.equals("valid") ? group_id : "unknown";
         endPoints.getGroupById(groupId);
    }

    @Given("A valid bitly groupId")
    public void aBitlyGroupId() {
        validGroupId = "Bk66h3Iprvs";
    }

    @Then("^The group details are returned$")
    public void theGroupDetailsAreReturned() {
        RestResponse<Group> groupResponse = new RestResponse(Group.class, endPoints.getResponse());
        Assert.assertEquals(200, groupResponse.getStatusCode());
        Assert.assertEquals(group_id, groupResponse.getBody().getGuid());
    }

    @Then("The user is forbidden to retrieve the groups info$")
    public void theUserIsForbidden() {
        RestResponse<Group> groupResponse = new RestResponse(Group.class, endPoints.getResponse());
        Assert.assertEquals(403, groupResponse.getStatusCode());
    }

//    @Then("^The group details are returned$")
//    public void invalidGroupIdSearchFailure() {
//        Assert.assertTrue(groupResponse.isSuccessful());
//        Assert.assertEquals(200, groupResponse.getStatusCode());
//        Assert.assertEquals(group_id, groupResponse.getBody().getGuid());
//        System.out.printf("status description: " + groupResponse.getResponse());
////        body.
////        Assert.assertEquals(USER_ID, groupResponse.getBody().);
////        Assert.assertEquals(book.isbn, userAccountResponse.getBody().books.get(0).isbn);
//    }
}
