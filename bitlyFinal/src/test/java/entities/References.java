package entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

//@Builder
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class References
{
    private String organization;
    private String group;
}
