package mx.openpay.apimarvelsdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Stories {
    private int available;
    private String returned;
    private String collectionURI;
    private List<Item> items;
}
