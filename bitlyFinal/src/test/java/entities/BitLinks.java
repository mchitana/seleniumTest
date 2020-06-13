package entities;

import java.util.List;

public class BitLinks {
    private List<SortedLink> sorted_links;

    private List<Link> links;

    public List<SortedLink> getSorted_links(){
        return this.sorted_links;
    }

    public List<Link> getLinks(){
        return this.links;
    }

}