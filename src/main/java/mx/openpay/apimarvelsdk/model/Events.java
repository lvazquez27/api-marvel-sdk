package mx.openpay.apimarvelsdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Events {
    private int available;
    private int returned;
    private String collectionURI;
    private List<Item> items;

}
