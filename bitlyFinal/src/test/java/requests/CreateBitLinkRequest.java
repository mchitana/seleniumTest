package requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.DeepLink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBitLinkRequest {
    private String domain;

    private String title;

    private String group_guid;

    private List<String> tags;

    private List<DeepLink> deeplinks;

    private String long_url;
}
