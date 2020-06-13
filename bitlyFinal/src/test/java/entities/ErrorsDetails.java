package entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorsDetails {
    private String message;
    private String resource;
    private String description;
    private List<ErrorCodes> errors;

}


