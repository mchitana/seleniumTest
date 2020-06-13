package entities;

public class DeepLink
{
    private String bitlink;

    private String install_url;

    private String created;

    private String app_uri_path;

    private String modified;

    private String install_type;

    private String app_guid;

    private String guid;

    private String os;

    private String brand_guid;

    public void setBitlink(String bitlink){
        this.bitlink = bitlink;
    }
    public String getBitlink(){
        return this.bitlink;
    }
    public void setInstall_url(String install_url){
        this.install_url = install_url;
    }
    public String getInstall_url(){
        return this.install_url;
    }
    public void setCreated(String created){
        this.created = created;
    }
    public String getCreated(){
        return this.created;
    }
    public void setApp_uri_path(String app_uri_path){
        this.app_uri_path = app_uri_path;
    }
    public String getApp_uri_path(){
        return this.app_uri_path;
    }
    public void setModified(String modified){
        this.modified = modified;
    }
    public String getModified(){
        return this.modified;
    }
    public void setInstall_type(String install_type){
        this.install_type = install_type;
    }
    public String getInstall_type(){
        return this.install_type;
    }
    public void setApp_guid(String app_guid){
        this.app_guid = app_guid;
    }
    public String getApp_guid(){
        return this.app_guid;
    }
    public void setGuid(String guid){
        this.guid = guid;
    }
    public String getGuid(){
        return this.guid;
    }
    public void setOs(String os){
        this.os = os;
    }
    public String getOs(){
        return this.os;
    }
    public void setBrand_guid(String brand_guid){
        this.brand_guid = brand_guid;
    }
    public String getBrand_guid(){
        return this.brand_guid;
    }
}

