package steps;

import api.EndPoints;
import api.RestResponse;
import entities.Group;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GroupSteps {
    public String validGroupId;
    private EndPoints endPoints ;
    private String group_id = "Bk66h3Iprvs";

    public GroupSteps(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    @Given("^user requests to get groups using (?:a)? (valid|invalid|missing) group_id$")
    public void getGroupById(String type) {
        switch (type){
            case "valid":
                endPoints.getGroupById(group_id);
                break;
            case "invalid":
                endPoints.getGroupById("fakeGroupId");
                break;
            case "missing" :
                endPoints.getGroupById("");
                break;
        }
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
//        Assert.assertEquals(403, groupResponse.getStatusCode());
    }
}
