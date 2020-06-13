package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.List;
//@Builder
@Getter
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    private References references;

    private String name;

    private List<String> bsds;

    private String created;

    private boolean is_active;

    private String modified;

    private String organization_guid;

    private String role;

    private String guid;

    public References getReferences() {
        return references;
    }

    public String getName() {
        return name;
    }

    public List<String> getBsds() {
        return bsds;
    }

    public String getCreated() {
        return created;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public String getModified() {
        return modified;
    }

    public String getOrganization_guid() {
        return organization_guid;
    }

    public String getRole() {
        return role;
    }

    public String getGuid() {
        return guid;
    }

    //    public void setReferences(References references){
//        this.references = references;
//    }
//    public References getReferences(){
//        return this.references;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getName(){
//        return this.name;
//    }
//    public void setBsds(List<String> bsds){
//        this.bsds = bsds;
//    }
//    public List<String> getBsds(){
//        return this.bsds;
//    }
//
//    public String getCreated(){
//        return this.created;
//    }
//
//    public boolean isActive(){
//        return this.is_active;
//    }
//
//    public String getModified(){
//        return this.modified;
//    }
//
//    public String getOrganizationGuid(){
//        return this.organization_guid;
//    }
//
//    public String getRole(){
//        return this.role;
//    }
//
//    public String getGuid(){
//        return this.guid;
//    }
}
