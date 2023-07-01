package mx.openpay.apimarvelsdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Result {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<Url> urls;
    private Thumbnail thumbnail;
    private Comics comics;
    private Stories stories;
    private Events events;
    private Series series;
}
