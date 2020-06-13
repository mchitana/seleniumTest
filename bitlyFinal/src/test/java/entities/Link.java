package entities;

import java.util.List;

public class Link
{
    private References references;

    private boolean archived;

    private List<String> tags;

    private String created_at;

    private String title;

    private List<DeepLink> deeplinks;

    private String created_by;

    private String long_url;

    private String client_id;

    private List<String> custom_bitlinks;

    private String link;

    private String id;

    public void setReferences(References references){
        this.references = references;
    }
    public References getReferences(){
        return this.references;
    }
    public void setArchived(boolean archived){
        this.archived = archived;
    }
    public boolean getArchived(){
        return this.archived;
    }
    public void setTags(List<String> tags){
        this.tags = tags;
    }
    public List<String> getTags(){
        return this.tags;
    }
    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDeeplinks(List<DeepLink> deeplinks){
        this.deeplinks = deeplinks;
    }
    public List<DeepLink> getDeeplinks(){
        return this.deeplinks;
    }
    public void setCreated_by(String created_by){
        this.created_by = created_by;
    }
    public String getCreated_by(){
        return this.created_by;
    }
    public void setLong_url(String long_url){
        this.long_url = long_url;
    }
    public String getLong_url(){
        return this.long_url;
    }
    public void setClient_id(String client_id){
        this.client_id = client_id;
    }
    public String getClient_id(){
        return this.client_id;
    }
    public void setCustom_bitlinks(List<String> custom_bitlinks){
        this.custom_bitlinks = custom_bitlinks;
    }
    public List<String> getCustom_bitlinks(){
        return this.custom_bitlinks;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return this.link;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}


