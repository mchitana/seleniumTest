package api;

public class RequestPaths {
    private static final String VERSION = "/v4";

    public static String groups(String groupId) {
        return VERSION + "/groups/" + groupId;
    }

    public static String allGroups() {
        return VERSION + "/groups";
    }

    public static String bitlinks() {
        return VERSION + "/bitlinks";
    }

    public static String sortedLinksByClicks(String groupId, String sortType) {
        return VERSION + "/groups/" + groupId + "/bitlinks/" + sortType;
    }
}
